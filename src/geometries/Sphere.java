package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.*;

public class Sphere extends RadialGeometry {
	private Point3D _center;

	// default cons
	public Sphere() {
		super();
		this._center = new Point3D();
	}

	// copy cons
	public Sphere(Sphere sphere) {
		super(sphere._radius);
		this._center = new Point3D(sphere._center);
	}

	// full cons
	public Sphere(double radius, Point3D center) {
		super(radius);
		this._center = new Point3D(center);
		
	}

	// getter
	public Point3D getCenter() {
		return _center;
	}

	// setter
	public void setCenter(Point3D _center) {
		this._center = new Point3D(_center);
	}

	
	//The function returns a list of all the points of intersection with the sphere
	@Override
	public List<Point3D> FindIntersections(Ray ray) {

		List<Point3D> _intersectionPointList = new ArrayList<Point3D>();
		Vector _l = new Vector(ray.get_POO(), _center);
		double _tm = _l.dotProduct(ray.get_direction());
		double _d = Math.sqrt(Math.pow(_l.length(), 2) - Math.pow(_tm, 2));

		if (_d > _radius)
			return _intersectionPointList;

		double _th = Math.sqrt(Math.pow(_radius, 2) - Math.pow(_d, 2));
		double _t1 = _tm - _th;
		double _t2 = _tm + _th;

		if (_t1 > 0) {
			Vector _tmp_v = new Vector(ray.get_direction());
			_tmp_v.scale(_t1);
			Point3D _p1 = new Point3D(ray.get_POO());
			_p1.add(_tmp_v);
			_intersectionPointList.add(_p1);
		}
		
			if (_t2 > 0) {
				Vector _tmp_v2 = new Vector(ray.get_direction());
				_tmp_v2.scale(_t2);
				Point3D _p2 = new Point3D(ray.get_POO());
				_p2.add(_tmp_v2);
				_intersectionPointList.add(_p2);
			}
		
		return _intersectionPointList;

	}

	//The function return the normal of the sphere
	@Override
	public Vector getNormal(Point3D point) {
		Vector _normal = new Vector(_center, point);
		_normal.normalize();
		return _normal;
	}

	@Override
	public Color getEmmission() {
		return get_emmission();
	}

}
