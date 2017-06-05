package geometries;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.*;

public class Triangle extends RadialGeometry{

	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;

	// Default cons
	public Triangle() {
		this._p1 = new Point3D();
		this._p2 = new Point3D();
		this._p3 = new Point3D();
	}

	// copy cons
	public Triangle(Triangle triangle) {
		this._p1 = new Point3D(triangle._p1);
		this._p2 = new Point3D(triangle._p2);
		this._p3 = new Point3D(triangle._p3);
	}

	// full cons
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		this._p1 = new Point3D(p1);
		this._p2 = new Point3D(p2);
		this._p3 = new Point3D(p3);
	}

	// getters
	public Point3D get_p1() {
		return _p1;
	}

	public Point3D get_p2() {
		return _p2;
	}

	public Point3D get_p3() {
		return _p3;
	}

	// setters
	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}

	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}

	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}

	//The function returns a list of all the points of intersection with the triangle
	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		
		List<Point3D> _intersectionPointList=new ArrayList<>();
		Plane _plane=new Plane(getNormal(_p3),_p3);
		_intersectionPointList=_plane.FindIntersections(ray);
		if(_intersectionPointList.size()==0)
			return _intersectionPointList;
		
		Vector _p0_p=new Vector(ray.get_POO(),_intersectionPointList.get(0));
		
		Vector _v1=new Vector(ray.get_POO(),_p1);
		Vector _v2=new Vector(ray.get_POO(),_p2);
		Vector _v3=new Vector(ray.get_POO(),_p3);
		
		Vector _normal1=_v1.crossProduct(_v2);
		Vector _normal2=_v2.crossProduct(_v3);
		Vector _normal3=_v3.crossProduct(_v1);
		
		_normal1.normalize();
		_normal2.normalize();
		_normal3.normalize();
		
		
		_normal1.scale(-1.0);
		_normal2.scale(-1.0);
		_normal3.scale(-1.0);
		
		
		double s1=_normal1.dotProduct(_p0_p);
		double s2=_normal2.dotProduct(_p0_p);
		double s3=_normal3.dotProduct(_p0_p);
		
		if(s1>0 && s2>0 && s3>0 || s1<0 && s2<0 && s3<0)
		return _intersectionPointList;
		
		
		_intersectionPointList.remove(0);
		return _intersectionPointList; 
	}

	//The function return the normal of the triangle
	@Override
	public Vector getNormal(Point3D point) {
		
		Vector _p1_p2=new Vector(_p1,_p2);
		Vector _p1_p3=new Vector(_p1,_p3);
		
		Vector _normal=new Vector(_p1_p2.crossProduct(_p1_p3));
		_normal.normalize();
		_normal.scale(-1);
		return _normal;
	}

	@Override
	public Color getEmmission() {
		return get_emmission();
	}
	
}
