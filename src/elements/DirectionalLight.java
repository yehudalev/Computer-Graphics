package elements;

import java.awt.Color;
import primitives.*;

public class DirectionalLight extends Light implements LightSource {

	private Vector direction;

	// default cons
	public DirectionalLight() {
		this.direction = new Vector();
		_color = new Color(255, 255, 255);
	}

	// full cons
	public DirectionalLight(Color color, Vector direction) {
		this._color = new Color(color.getRGB());
		this.direction = new Vector(direction);
	}

	//get intensity 
	@Override
	public Color getIntensity() {
		return new Color(this._color.getRGB());
	}

	//get direction
	public Vector getDirection() {
		return new Vector(this.direction);
	}

	//set direction
	public void setDirection(Vector direction) {
		this.direction = new Vector(direction);
	}

	//we implement the Light source operation, get the intensity of the direction light
	@Override
	public Color getIntensity(Point3D point) {
		return new Color(_color.getRGB());
	}

	//get the vector from the source light to the point the we calculate
	@Override
	public Vector getL(Point3D point) {
		return new Vector(point); // the sun for example is too far
	}

}
