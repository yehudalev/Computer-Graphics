package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import elements.LightSource;
import geometries.*;
import primitives.*;
import scene.Scene;

public class Render {

	private Scene _scene;
	private ImageWriter _imageWriter;
	// private final int RECURSION_LEVEL = 3;

	// Constructor
	public Render(ImageWriter imageWriter, Scene scene) {

		_scene = new Scene(scene);
		_imageWriter = new ImageWriter(imageWriter);

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

	// render image
	public void renderImage() {
		for (int i = 0; i < this._imageWriter.getNx(); i++)
			for (int j = 0; j < this._imageWriter.getNy(); j++) {
				Ray ray = _scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,
						_scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				Map<Geometry, List<Point3D>> interSectionPoints = getSceneRayIntersections(ray);
				if (interSectionPoints.isEmpty())
					_imageWriter.writePixel(j, i, _scene.getBackground());
				else {
					Map<Geometry, Point3D> closetPoint = getClosetPoint(interSectionPoints);
					Set<Geometry> v = closetPoint.keySet();
					Geometry firstGeo = v.iterator().next();
					_imageWriter.writePixel(j, i, calcColor(firstGeo, closetPoint.get(firstGeo)));
				}
			}
	}

	// services for the render-image operation
	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		Geometry geometry = null;
		while (geometries.hasNext()) {
			geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
			if (!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		return intersectionPoints;
	}

	// calculate point color
	private Color calcColor(Geometry geometry, Point3D point) {

		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color emissionLight = geometry.get_emmission();
		// we need to calculate each source light in the point, then we need
		// iterator
		Iterator<LightSource> lights = _scene.getLightsIterator();
		Color diffuseLight = new Color(0, 0, 0);
		Color specularLight = new Color(0, 0, 0);
		while (lights.hasNext()) {
			LightSource current_light = lights.next();
			diffuseLight = addColors(diffuseLight, calcDiffusiveComp(geometry.get_material().getKd(),
					geometry.getNormal(point), current_light.getL(point), current_light.getIntensity(point)));
			specularLight = addColors(specularLight,
					calcSpecularComp(geometry.get_material().getKs(), new Vector(point, _scene.getCamera().getP0()),
							geometry.getNormal(point), current_light.getL(point), geometry.get_nShininess(),
							current_light.getIntensity(point)));
		}
		Color a_e = addColors(emissionLight, ambientLight);
		Color d_s = addColors(diffuseLight, specularLight);
		return addColors(a_e, d_s);
	}

	// get the closet point to calculate the color for our image
	private Map<Geometry, Point3D> getClosetPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.getCamera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
			for (Point3D point : entry.getValue()) {
				if (point.distance(P0) < distance) {
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}

			}
		}
		return minDistancePoint;
	}

	// write the scene to image
	public void writeToImage() {
		this._imageWriter.writeToimage();
	}

	private Color addColors(Color a, Color b) {

		int _red = a.getRed() + b.getRed();
		int _green = a.getGreen() + b.getGreen();
		int _blue = a.getBlue() + b.getBlue();

		_red = Math.min(_red, 255);
		_green = Math.min(_green, 255);
		_blue = Math.min(_blue, 255);

		return new Color(_red, _green, _blue);
	}

	private Color calcDiffusiveComp(double Kd, Vector normal, Vector l, Color lightIntensity) {

		Vector L = new Vector(l);
		L.scale(-1);

		double N_L = normal.dotProduct(L); // here we calculate the dot product
											// number
											// of the diffuse part
		if (N_L < 0)
			N_L = (-1) * N_L;
		N_L = Kd * N_L;

		int _red = (int) (lightIntensity.getRed() * N_L);
		int _green = (int) (lightIntensity.getGreen() * N_L);
		int _blue = (int) (lightIntensity.getBlue() * N_L);

		_red = Math.min(_red, 255);
		_green = Math.min(_green, 255);
		_blue = Math.min(_blue, 255);

		return new Color(_red, _green, _blue);
	}

	private Color calcSpecularComp(double Ks, Vector P0, Vector normal, Vector L, double Shininess,
			Color lightIntensity) {
		Vector r = new Vector(normal);
		double tmp = r.dotProduct(L); // here we get the dot product of D*L as
										// shown in the נוסחיה
		tmp = 2 * tmp;
		r.scale(tmp); // here we multiplex with the result
		Vector vecTemp = new Vector(L);
		vecTemp.subtract(r);
		r = vecTemp;
		r.normalize();
		P0.normalize();

		double V_R = P0.dotProduct(r);

		if (V_R < 0)
			V_R = (-1) * V_R; // if it is in the other side of the
								// geometry
		V_R = Ks * Math.pow(V_R, Shininess);
		int _red = (int) (lightIntensity.getRed() * V_R);
		int _green = (int) (lightIntensity.getGreen() * V_R);
		int _blue = (int) (lightIntensity.getBlue() * V_R);

		_red = Math.min(_red, 255);
		_green = Math.min(_green, 255);
		_blue = Math.min(_blue, 255);

		return new Color(_red, _green, _blue);
	}

	public void printGrid(int interval) {
		for (int i = 0; i < _imageWriter.getWidth(); i += interval) {
			for (int j = 0; j < _imageWriter.getHeight(); j++) {
				_imageWriter.writePixel(i, j, Color.WHITE);
				_imageWriter.writePixel(j, i, Color.WHITE);
			}
		}
	}
}
