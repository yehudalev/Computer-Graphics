package geometries;

import java.awt.Color;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class RadialGeometry extends Geometry {

	protected double _radius;

	// Default cons
	public RadialGeometry() {
		this._radius = 0;
	}

	// copy cons
	public RadialGeometry(RadialGeometry r) {
		this._radius = r._radius;
	}

	// full cons
	public RadialGeometry(double radius) {
		this._radius = radius;
	}

	// getter and setter
	public double getRadius() {
		return _radius;
	}

	public void setRadius(double radius) {
		_radius = radius;
	}

}
