package geometries;

import java.awt.Color;
import java.util.List;

import primitives.*;

public class Cylinder extends RadialGeometry {

	private Point3D _axisPoint;
	private Vector _axisDirection;

	// default cons
	public Cylinder() {
		super();
		this._axisPoint = new Point3D();
		this._axisDirection = new Vector();
	}

	// copy cons
	public Cylinder(Cylinder cylinder) {
		super(cylinder._radius);
		this._axisDirection = cylinder._axisDirection;
		this._axisPoint = cylinder._axisPoint;
	}

	// full cons
	public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
		super(radius);
		this._axisDirection = new Vector(axisDirection);
		this._axisPoint = new Point3D(axisPoint);
	}

	// getters
	public Point3D getAxisPoint() {
		return _axisPoint;
	}

	public Vector getAxisDirection() {
		return _axisDirection;
	}

	// setters
	public void setAxisPoint(Point3D _axisPoint) {
		this._axisPoint = new Point3D(_axisPoint);
	}

	public void setAxisDirection(Vector _axisDirection) {
		this._axisDirection = new Vector(_axisDirection);
	}

	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color get_emission() {
		// TODO Auto-generated method stub
		return null;
	}

}
