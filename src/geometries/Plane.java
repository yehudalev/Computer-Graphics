package geometries;
import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Plane extends RadialGeometry {
	private Vector _normal;
	private Point3D _Q;

	// Default cons
	public Plane() {
		this._normal = new Vector();
		this._Q = new Point3D();
	
	}

	// copy cons
	public Plane(Plane plane) {
		this._normal = new Vector(plane._normal);
		this._Q = new Point3D(plane._Q);
		this.set_emmission(plane.get_emmission());
		this.set_material(plane.get_material());
		this.set_nShininess(plane.get_nShininess());
	}

	// full cons
	public Plane(Vector normal, Point3D q,Color _em,Material _mat,double _nSh) {
		this._normal = new Vector(normal);
		this._Q = new Point3D(q);
		this.set_emmission(_em);
		this.set_material(_mat);
		this.set_nShininess(_nSh);
		
	}
	public Plane(Vector normal, Point3D q) {
		this._normal = new Vector(normal);
		this._Q = new Point3D(q);
	
		
	}

	// getters
	@Override
	public Vector getNormal(Point3D point) {
		return _normal;
	}

	public Point3D getQ() {
		return _Q;
	}

	// setters
	public void setNormal(Vector _normal) {
		this._normal = new Vector(_normal);
	}

	public void setQ(Point3D _Q) {
		this._Q = new Point3D(_Q);
	}

	
	//The function returns a list of all the points of intersection with the plane
	@Override
	public List<Point3D> FindIntersections(Ray ray) {

		List<Point3D> _intersectionPointList=new ArrayList<>();
		
		Vector _temNormal = new Vector(_normal);
		_temNormal.scale(-1.0);
		Vector _P0_Q = new Vector(_Q,ray.get_POO());
		double _t = _temNormal.dotProduct(_P0_Q) / (double) (_normal.dotProduct(ray.get_direction()));
		if (_t >= 0) {
			
			Vector _tmp_v = new Vector(ray.get_direction());
			_tmp_v.scale(_t);
			Point3D _new_p=new Point3D(ray.get_POO());
			_new_p.add(_tmp_v);
			_intersectionPointList.add(_new_p);

		}

		return _intersectionPointList;
	}





}
