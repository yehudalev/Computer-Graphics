package elements;

import java.awt.Color;
import primitives.*;

public class PointLight extends Light implements LightSource {

	Point3D _position;
	double _Kc, _Kl, _Kq;

	// full cons
	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
		this._color = new Color(color.getRGB());
		this._Kc = kc;
		this._Kl = kl;
		this._Kq = kq;
		this._position = position;
	}

	@Override
	public Color getIntensity() {
		return new Color(this._color.getRGB());
	}

	@Override
	public Vector getL(Point3D point) {
		Vector vector = new Vector(this._position, point);
		vector.normalize();
		return vector;
	}

	@Override
	public Color getIntensity(Point3D point) {
		double distance = point.distance(_position);
		double tmp = _Kc + distance * _Kl + distance * distance * _Kq; // calculate
																		// the
																		// real
																		// number
		int _red = Math.min((int) (_color.getRed() / tmp), 255);
		int _green = Math.min((int) (_color.getGreen() / tmp), 255);
		int _blue = Math.min((int) (_color.getBlue() / tmp), 255);

		return new Color(_red, _green, _blue);
	}

}
