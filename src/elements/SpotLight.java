package elements;

import java.awt.Color;

import primitives.*;

public class SpotLight extends PointLight{

	private Vector _direction;
	
	//full cons
	public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq){
		super(color, position, kc, kl, kq);
		this._direction=new Vector(direction);
	}

	
	@Override
	public Vector getL(Point3D point) {
		Vector vector=new Vector(_position, point);
		vector.normalize();
		return new Vector(vector);
	}
	
	@Override
	public Color getIntensity(Point3D point) {
		double distance = point.distance(_position);
		
		Color color = getIntensity();
		int _red = (int)((color.getRed()*(_direction.dotProduct(getL(point))))/_Kc * distance * _Kl * distance * distance * _Kq );
		int _green = (int)((color.getGreen()*(_direction.dotProduct(getL(point))))/_Kc * distance * _Kl * distance * distance * _Kq );
		int _blue = (int)((color.getBlue()*(_direction.dotProduct(getL(point))))/_Kc * distance * _Kl * distance * distance * _Kq );
		
		return new Color(_red, _green, _blue);
	}
}
