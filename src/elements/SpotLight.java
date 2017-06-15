package elements;

import java.awt.Color;

import primitives.*;

public class SpotLight extends PointLight {

	private Vector _direction;

	// full cons
	public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq) {
		super(color, position, kc, kl, kq);
		this._direction = new Vector(direction);
	}

	@Override
	public Vector getL(Point3D point) {
		Vector vector = new Vector(this._position, point);
		vector.normalize();
		return vector;
		// return super.getL(point);
	}

	@Override
	public Color getIntensity(Point3D point) {
		double distance = point.distance(_position);
		// calculate direction dot product L
		double tmp = _direction.dotProduct(getL(point));

		tmp = tmp / (_Kc + distance * _Kl + distance * distance * _Kq);

		int _red = Math.min((int) (_color.getRed() / tmp), 255);
		int _green = Math.min((int) (_color.getGreen() / tmp), 255);
		int _blue = Math.min((int) (_color.getBlue() / tmp), 255);

		return new Color(_red, _green, _blue);
	}
}
