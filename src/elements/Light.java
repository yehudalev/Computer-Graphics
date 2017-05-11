package elements;

import java.awt.Color;



public class Light {
	
	protected Color _color;
	public Light(){
		_color=new Color(0,0,0);
	}
	public Light (Color color)
	{
		_color=new Color(color.getRGB());
	}
	
	public Color getIntensity()
	{
		
		return null;
	}

}
