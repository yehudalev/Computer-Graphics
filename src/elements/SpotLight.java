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

	//get the vector from the source light to the point the we calculate
	@Override
	public Vector getL(Point3D point) {
		 return super.getL(point);
	}

	//we implement the Light source operation, get the intensity of the direction light
	@Override
	public Color getIntensity(Point3D point) {
		
		double distance = point.distance(_position);
		Color _pointColor= this.getIntensity();
		Vector L = new Vector(getL(point));
	    L.normalize();
		double tmp = Math.abs(_direction.dotProduct(L));

		tmp = tmp / (_Kc + distance * _Kl + distance * distance * _Kq);

		int _red = Math.min((int) (_pointColor.getRed() * tmp), 255);
		int _green = Math.min((int) (_pointColor.getGreen()* tmp), 255);
		int _blue = Math.min((int) (_pointColor.getBlue() * tmp), 255);

		return new Color(_red, _green, _blue);
	}
}
