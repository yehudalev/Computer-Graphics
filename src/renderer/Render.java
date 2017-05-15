package renderer;


import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import elements.LightSource;
import geometries.*;
import primitives.*;
import scene.Scene;
public class Render {
	
	
	private Scene _scene;
	private ImageWriter _imageWriter;
	private final int RECURSION_LEVEL = 3;
	
	//cons
	public Render(ImageWriter imageWriter, Scene scene){
		
		_scene=new Scene(scene);
		_imageWriter=new ImageWriter(imageWriter);
		
	}
	
	public void renderImage(){
		for (int i=0; i<this._imageWriter.getNx(); i++)
			for(int j=0; j<this._imageWriter.getNy(); j++)
			{
				Ray ray=_scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j,
																			_scene.getScreenDistance(), _imageWriter.getWidth(), _imageWriter.getHeight());
				List<Point3D> interSectionPoints= getSceneRayIntersections(ray);
				if (interSectionPoints == null)
					_imageWriter.writePixel(j, i, _scene.getBackground());
				else 
				{
					Point3D closetPoint = getClosetPoint(interSectionPoints);
					_imageWriter.writePixel(i, j, calcColor(closetPoint));
				}
			}
	}
	private List<Point3D> getSceneRayIntersections(Ray ray){
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		List<Point3D> intersectionPoints = new ArrayList<Point3D>();
		Geometry geometry=null;
		while (geometries.hasNext())
		{
			geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.FindIntersections(ray);
			intersectionPoints.addAll(geometryIntersectionPoints);
		}
		return intersectionPoints;
	}
	
	private Color calcColor(Point3D point){
		return _scene.getAmbientLight().getIntensity();
	}
	
	private Point3D getClosetPoint(List<Point3D> intersectionPoints){
		double distance = Double.MAX_VALUE;
		Point3D P0 =_scene.getCamera().getP0();
		Point3D minDistancePoint=null;
		for(Point3D point: intersectionPoints)
		{
			if (P0.distance(point) < distance)
			{
				minDistancePoint = new Point3D(point);
				distance = P0.distance(point); 
			}
		}
		return minDistancePoint;
	}
	

	/*
	private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray)
	{
		
	}
	*/
	public void printGrid(int interval)
	{
		
	}
	public void writeToImage(){
		
	}
	

	/*
	private Color calcColor(Geometry geometry, Point3D point, Ray ray){
		
	}

	private Color calcColor(Geometry geometry, Point3D point,
	Ray inRay, int level){
	
}
	private Ray constructRefractedRay(Geometry geometry, Point3D point,
	Ray inRay){
		
	}
	private Ray constructReflectedRay(Vector normal, Point3D point,
	Ray inRay){
		
	}
	private boolean occluded(LightSource light, Point3D point,
	Geometry geometry){
		
	}
	private Color calcSpecularComp(double ks, Vector v, Vector normal,
	Vector l, double shininess, Color lightIntensity)
	{
		
	}
	private Color calcDiffusiveComp(double kd, Vector normal, Vector l,
	Color lightIntensity){
		
	}
	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry,
	List<Point3D>> intersectionPoints){
		
	}
	private Map<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray){
		
	}
	private Color addColors(Color a, Color b){
		
	}

	*/
}
