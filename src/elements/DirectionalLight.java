package elements;

import java.awt.Color;
import primitives.*;
public class DirectionalLight extends Light implements LightSource{

	private Vector direction;
	
	//default cons 
	public DirectionalLight()
	{
		this.direction=new Vector();
		_color = new Color(255,255,255);
	}
	
	//full cons
	public DirectionalLight(Color color, Vector direction){
		this._color= new Color(color.getRGB());
		this.direction=new Vector(direction);
	}
	
	@Override
	public Color getIntensity() {
		return this._color;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = new Vector(direction);
	}

	@Override
	public Color getIntensity(Point3D point) {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public Vector getL(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
