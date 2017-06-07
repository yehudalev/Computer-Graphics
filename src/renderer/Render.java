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
					_imageWriter.writePixel(i, j, calcColor(firstGeo, closetPoint.get(firstGeo)));
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
			intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		return intersectionPoints;
	}

	// calculate point color
	private Color calcColor(Geometry geometry, Point3D point) {
		Color ambientLight = _scene.getAmbientLight().getIntensity();
		Color emissionLight = geometry.get_emmission();
		
		//we need to check here it is not finished
		Color I0 = new Color(ambientLight.getRed() + emissionLight.getRed(),
				ambientLight.getGreen() + emissionLight.getGreen(), ambientLight.getBlue() + emissionLight.getBlue());
		return I0;
	}

	// get the closet point to calculate the color for our image
	private Map<Geometry, Point3D> getClosetPoint(Map<Geometry, List<Point3D>> intersectionPoints) {
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.getCamera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet()) {
			for (Point3D point : entry.getValue()) {
				if (P0.distance(point) < distance) {
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
				}
			}
		}
		return minDistancePoint;
	}

	// write the scene to image
	public void writeToImage() {
		this._imageWriter.writeToimage();
	}

}
