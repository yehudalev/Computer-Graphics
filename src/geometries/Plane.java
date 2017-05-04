package geometries;

import primitives.*;

public class Plane {
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
	}

	// full cons
	public Plane(Vector normal, Point3D q) {
		this._normal = new Vector(normal);
		this._Q = new Point3D(q);
	}

	// getters
	public Vector getNnormal() {
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

}
