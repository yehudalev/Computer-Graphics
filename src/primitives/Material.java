package primitives;

public class Material {

	private double _Kd; // Diffusion attenuation factors
	private double _Ks; // Specular  attenuation factors
	private int _nShininess;  // Shininess attenuation factors 	 

	// default cons
	public Material() {
		_Kd = 1;
		_Ks = 1;
		_nShininess = 1;
	}


	// copy cons
	public Material(Material material) {
		this._Kd = material._Kd;
		this._Ks = material._Ks;
		this._nShininess = material._nShininess;

	}

	// getters

	public double getKd() {
		return this._Kd;
	}

	public double getKs() {
		return this._Ks;
	}

	public double getN() {
		return this._nShininess;
	}

	// setters
	public void setKd(double _Kd) {
		this._Kd = _Kd;
	}

	public void setKs(double _Ks) {
		this._Ks = _Ks;
	}
	
	public void setN(int _nShininess) {
		this._nShininess = _nShininess;
	}

}
