package elements;

import java.awt.Color;



public class Light {
	
	protected Color _color;
	
	//default cons the most light-white
	public Light(){
		
		_color=new Color(255, 255, 255);
	}
	
	//copy cons
	public Light (Color color)
	{
		_color=new Color(color.getRGB());
	}
	
	//operations
	public Color getIntensity()
	{
		return null;
	}
}
