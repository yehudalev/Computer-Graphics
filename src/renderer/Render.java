package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class Render {

	private Scene _scene;
	private ImageWriter _imageWriter;
	private final int RECURSION_LEVEL = 3;
	
	//fields that we use for distribution of rays
	Random random = new Random();
	private int level = 15;

	// full cons
	public Render(ImageWriter imageWriter, Scene scene) {
		_imageWriter = new ImageWriter(imageWriter);
		_scene = new Scene(scene);
	}

	// copy cons
	public Render(Render render) {
		this(render._imageWriter, render._scene);
	}

	//Constructor with one parameter "level" which is how many rays to distribute by pixel 
	public Render(int level) {
		_scene = new Scene();
		this.level = level;
	}

	// setters and getters
	public void setScene(Scene scene) {
		_scene = new Scene(scene);
	}

	public void setImageWriter(ImageWriter imageWriter) {
		_imageWriter = new ImageWriter(imageWriter);
	}

	public Scene getScene() {
		return _scene;
	}

	public ImageWriter getImageWriter() {
		return _imageWriter;
	}

	// operations

	// optional, here we print the grid (white lines)
	public void printGrid(int interval) {
		for (int i = 0; i < _imageWriter.getNx() / interval; i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) {
				_imageWriter.writePixel(j, i * interval, 255, 255, 255);
				_imageWriter.writePixel(i * interval, j, 255, 255, 255);
			}
		}
	}

	// write the scene to image
	public void writeToImage() {
		_imageWriter.writeToimage();
	}

	// services for the render-image operation
	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
		//allocate iterator that pass every geometric in the scene and finds every geometric's points intersections 
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		//allocate map that contains each geometric (key) with his intersections points
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		while (geometries.hasNext()) {
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
			//only if we find point(s) intersection we add to the container, others, we ignore. 
			if (geometryIntersectionPoints.size() > 0)
				intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		return intersectionPoints;
	}

	// render image
	public void renderImage() {
		//allocate an array list that holds for each pixel his colors, that we calculate from distribution rays 
		ArrayList<Color> pixelColorsList = new ArrayList<>();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();

		//fields that we use for calculate range of random of half with and half height
		//width and height of an specific pixel  
		double w_per_pix = _imageWriter.getWidth() / _imageWriter.getNx();
		double h_per_pix = _imageWriter.getHeight() / _imageWriter.getNy();
		for (int i = 0; i < _imageWriter.getNx(); i++) {
			for (int j = 0; j < _imageWriter.getNy(); j++) { //here the internal loop we shot distribution ray per pixel (by given level)
				for (int k = 0; k < level; k++) {
					double r1 = random.nextDouble() - 0.5; // random range
															// [-0.5, 0.5]
					double r2 = random.nextDouble() - 0.5; // random range
															// [-0.5, 0.5]
					//here we calculate the final range that we allowed, [-0.5*width, +0.5*width] and [-0.5*width, +0.5*width]. 
					double ex_i = r1 * w_per_pix + i;
					double ex_j = r2 * h_per_pix + j;

					//shot ray
					Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(),
							ex_i, ex_j, _scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());

					//finds intersections points for the ray above
					intersectionPoints = getSceneRayIntersections(ray);
					if (intersectionPoints.isEmpty()) {
						pixelColorsList.add(_scene.getBackground());  //no points, then add background color
					}
					else {
						//found points, then we calculate the closet points and add it to the array list for average
						Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
						pixelColorsList.add(calcColor((Geometry) (closestPoint.keySet().toArray()[0]), (Point3D) closestPoint.get(closestPoint.keySet().toArray()[0]), ray));
					}
				} //here end of 3rd of internal loop
				
				//calculate the average color by given array list of colors 
				int _red = 0;
                int _green = 0;
                int _blue = 0;
                for (int k = 0; k < level; k++) {
                	_red += pixelColorsList.get(k).getRed();
                	_green += pixelColorsList.get(k).getGreen();
                	_blue += pixelColorsList.get(k).getBlue();
                }
                _red /= level;
                _green /= level;
                _blue /= level;
                
                //write color to image pixel
                _imageWriter.writePixel(i, j, new Color(_red, _green, _blue));
                pixelColorsList.clear();
			}
		}
	}

	// get the closet point to calculate the color for our image
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
		//initial the distance id the max that double can hold
		double distance = Double.MAX_VALUE;
		//the closet point is the most close to the P0
		Point3D P0 = _scene.getCamera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
			for (Point3D point : entry.getValue()) {
				//if we find closer point than the last closet point that calculated then we initial it
				if (P0.distance(point) < distance) {
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
			}
		}
		return minDistancePoint;
	}

	// calculate point color- 3 parameters, the user doesn't need to figure out the 4th parameters 
	private Color calcColor(Geometry geometry, Point3D point, Ray ray) {
		return calcColor(geometry, point, ray, 0);
	}

	// calculate point color- 4 parameters 
	private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {
		//the base condition stop the recursive calls
		if (level == RECURSION_LEVEL) {
			return new Color(0, 0, 0);
		}
		//fields that will holds the parts of Phong model
		Color emissionLight = geometry.get_emmission();
		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		//allocate iterator that will ask every source light what color he add to the specific point
		Iterator<LightSource> lights = _scene.getLightsIterator();
		while (lights.hasNext()) {
			LightSource light = lights.next();
			//we need to check if the point is not blocked by the source light, if then ignore it 
			//(means: there is no what to calculate the diffuse and secular)
			if (!occluded(light, point, geometry)) {
				
				//add diffuse to our scene
				diffuseLight = addColors(diffuseLight, calcDiffusiveComp(geometry.get_material().getKd(),
						geometry.getNormal(point), light.getL(point), light.getIntensity(point)));
				//add specular to our scene 
				specularLight = addColors(specularLight,
						calcSpecularComp(geometry.get_material().getKs(), new Vector(point, _scene.getCamera().getP0()),
								geometry.getNormal(point), light.getL(point), geometry.get_nShininess(),
								light.getIntensity(point)));
			}
		}
		//here we calculate the reflected and the refracted of the given geometric 
		Vector vector = geometry.getNormal(point);
		Ray reflectedRay = constructReflectedRay(vector, point, inRay);
		Map<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
		//we start from the 0 color and then we consume 
		Color reflectedColor = new Color(0, 0, 0);
		Color reflectedLight = new Color(0, 0, 0);
		//if we got intersection then get it and calculate
		if (!reflectedEntry.isEmpty()) {

			//here we call recursive 
			reflectedColor = calcColor(reflectedEntry.entrySet().iterator().next().getKey(),
					reflectedEntry.entrySet().iterator().next().getValue(), reflectedRay, level + 1);
			//when we come back from our recursive then we multiplex the the material (which is the parameter of the reflected in this point)
			reflectedLight = multColor(reflectedColor, geometry.get_material().getKr());
		}

		//calculate the refracted 
		Ray refractedRay = constructRefractedRay(geometry, point, inRay);
		Map<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
		Color refractedColor = new Color(0, 0, 0);
		Color refractedLight = new Color(0, 0, 0);

		if (!refractedEntry.isEmpty()) {
			//recursive call
			refractedColor = calcColor(refractedEntry.entrySet().iterator().next().getKey(),
					refractedEntry.entrySet().iterator().next().getValue(), refractedRay, level + 1);
			refractedLight = multColor(refractedColor, geometry.get_material().getKt());
		}

		return addColors(addColors(addColors(ambientLight, emissionLight), addColors(diffuseLight, specularLight)),
				addColors(reflectedLight, refractedLight));
	}

	// returen construct Reflected Ray
	private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {

		Vector _r = inRay.get_direction();
		double _tmp = _r.dotProduct(normal) * 2;
		Vector _n = new Vector(normal);
		_n.normalize();
		_n.scale(_tmp);
		_r.subtract(_n);
		Vector _v = new Vector(normal);

		if (normal.dotProduct(_r) < 0)
			_v.scale(-2);
		else
			_v.scale(2);

		Point3D _p = new Point3D(point);
		_p.add(_v);
		return new Ray(_p, _r);

	}

	// returen construct Refracted Ray
	private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay) {

		Vector _n = geometry.getNormal(point);
		Vector _direction = inRay.get_direction();
		double tmp = _n.dotProduct(_direction);
		if (tmp < 0)
			_n.scale(-2);
		else
			_n.scale(2);

		Point3D point2 = new Point3D(point);
		point2.add(_n);
		return new Ray(point2, _direction);
	}

	// the point that closet point
	private Map<Geometry, Point3D> findClosesntIntersection(Ray ray) {
		Map<Geometry, List<Point3D>> intersections = getSceneRayIntersections(ray);
		double distance = Double.MAX_VALUE;
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry : intersections.entrySet()) {
			for (Point3D point : entry.getValue()) {
				if (ray.get_POO().distance(point) < distance) {
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = ray.get_POO().distance(point);
				}
			}
		}
		return minDistancePoint;
	}

	// equals 0 if ray is blocked, and 1 otherwise
	private boolean occluded(LightSource light, Point3D point, Geometry geometry) {

		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);
		geometryPoint.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);

		if (geometry instanceof FlatGeometry) {
			intersectionPoints.remove(geometry);
		}

		for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
			if (entry.getKey().get_material().getKt() == 0)
				return true;
		return false;

	}

	// calculate the diffus part of Phong model
	private Color calcDiffusiveComp(double kd, Vector normal, Vector l, Color lightIntensity) {
		l.normalize();
		normal.normalize();
		double N_L = normal.dotProduct(l); // here we calculate the dot product
		N_L = kd * (Math.abs(N_L));

		return multColor(lightIntensity, N_L);
	}

	/// calculate the diffus part of Phong model
	private Color calcSpecularComp(double Ks, Vector P0, Vector normal, Vector L, double Shininess,
			Color lightIntensity) {
		Vector r = new Vector(normal);
		double tmp = r.dotProduct(L); // here we get the dot product of D*L as
		tmp = 2 * tmp;
		r.scale(tmp); // here we multiplex with the result
		Vector vecTemp = new Vector(L);
		vecTemp.subtract(r);
		r = vecTemp;
		r.normalize();
		P0.normalize();

		double V_R = Math.abs(P0.dotProduct(r));

		V_R = Ks * Math.pow(V_R, Shininess);
		int _red = (int) (lightIntensity.getRed() * V_R);
		int _green = (int) (lightIntensity.getGreen() * V_R);
		int _blue = (int) (lightIntensity.getBlue() * V_R);

		_red = Math.min(_red, 255);
		_green = Math.min(_green, 255);
		_blue = Math.min(_blue, 255);

		return new Color(_red, _green, _blue);
	}

	// multiplex the color with scalar
	private Color multColor(Color lightIntensity, double rgb) {

		int r = Math.min((int) (rgb * lightIntensity.getRed()), 255);
		int g = Math.min((int) (rgb * lightIntensity.getGreen()), 255);
		int b = Math.min((int) (rgb * lightIntensity.getBlue()), 255);
		return new Color(r, g, b);
	}

	// function that sum 2 color into one color
	private Color addColors(Color a, Color b) {

		int _red = a.getRed() + b.getRed();
		int _green = a.getGreen() + b.getGreen();
		int _blue = a.getBlue() + b.getBlue();

		_red = Math.min(_red, 255);
		_green = Math.min(_green, 255);
		_blue = Math.min(_blue, 255);

		return new Color(_red, _green, _blue);
	}

}