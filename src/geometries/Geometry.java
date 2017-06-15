package geometries;

import primitives.*;
import primitives.Point3D;

import java.awt.Color;
import java.util.List;

public abstract class Geometry {

	private Color _emmission = new Color(0, 0, 0);
	private Material _material = new Material();
	private double _nShininess = 1;

	// operations that every classes that inherit this needs to implement those
	public abstract List<Point3D> FindIntersections(Ray ray);

	public abstract Vector getNormal(Point3D point);

	// getters and setters
	public Color get_emmission() {
		return _emmission;
	}

	public void set_emmission(Color _emmission) {
		this._emmission = new Color(_emmission.getRGB());
	}

	public Material get_material() {
		return _material;
	}

	public void set_material(Material _material) {
		this._material = new Material(_material);
	}

	public double get_nShininess() {
		return _nShininess;
	}

	public void set_nShininess(double _nShininess) {
		this._nShininess = _nShininess;
	}
}
