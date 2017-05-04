package geometries;

public class RadialGeometry {

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
