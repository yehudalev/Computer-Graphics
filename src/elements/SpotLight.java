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

	//operation
	//public Color getIntensity(Point3D point);
}
