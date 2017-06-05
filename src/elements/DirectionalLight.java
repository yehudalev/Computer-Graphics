package elements;

import java.awt.Color;
import primitives.*;
public class DirectionalLight extends Light {

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
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = new Vector(direction);
	}
	
	

}
