package elements;

import java.awt.Color;
//import java.util.Map;

public class AmbientLight extends Light {
	private final double _Ka = 0.1;

	// ***************** Constructors ********************** //
	public AmbientLight() {
		_color = new Color(0, 0, 0);
	}

	public AmbientLight(AmbientLight aLight) {
		_color = new Color(aLight.getColor().getRGB());
	}

	public AmbientLight(int r, int g, int b) {
		_color = new Color(r, g, b);
	}
	/*
	 * public AmbientLight(Map<String, String> attributes) {
	 * 
	 * }
	 */

	public Color getColor() {
		return _color;
	}

	public void setColor(Color color) {

		_color = new Color(color.getRGB());
	}

	public double getKa() {

		return _Ka;
	}

	@Override
	public Color getIntensity() {
		return null;
	}
}