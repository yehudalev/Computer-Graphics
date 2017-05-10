package elements;

import primitives.*;

public class Camera {

	// Eye point of the camera
	private Point3D _P0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;

	// default cons
	public Camera() {
		this._P0 = new Point3D();
		this._vUp = new Vector();
		this._vTo = new Vector();
		this._vRight = new Vector();
	}

	// copy cons
	public Camera(Camera camera) {
		this._P0 = new Point3D(camera._P0);
		this._vUp = new Vector(camera._vUp);
		this._vTo = new Vector(camera._vTo);
		this._vRight = new Vector(this._vUp.crossProduct(_vTo));
	}

	// full cons

	public Camera(Point3D P0, Vector vUp, Vector vTo) {
		this._P0 = new Point3D(P0);
		this._vUp = new Vector(vUp);
		this._vTo = new Vector(vTo);
		this._vRight = new Vector(this._vUp.crossProduct(_vTo));
	}

	// getter
	public Vector get_vUp() {
		return this._vUp;
	}

	public Point3D getP0() {
		return this._P0;
	}

	public Vector get_vRight() {
		return this._vRight;
	}

	public Vector get_vTo() {
		return this._vTo;
	}

	// setters
	public void set_vUp(Vector vUp) {
		this._vUp = new Vector(vUp);
		this._vRight = this._vUp.crossProduct(_vTo);
	}

	public void set_vTo(Vector vTo) {
		this._vTo = new Vector(vTo);
		this._vRight = this._vUp.crossProduct(_vTo);
	}

	public void setP0(Point3D P0) {
		this._P0 = new Point3D(P0);
	}

	// toString print the camera object
	@Override
	public String toString() {
		return "Vto: " + _vTo + "\n" + "Vup: " + _vUp + "\n" + "Vright:" + _vRight + ".";
	}

	// operations

	// construct ray through pixel
	public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist, double screenWidth,
			double screenHeight) {

		// copy the class members to new variables to avoid changes in the
		// current class members

		Vector vUp = new Vector(this._vUp);
		Vector vRight = new Vector(this._vRight);

		// calculate ratio pixel width as Rx and ratio pixel height as Ry
		double Rx = screenWidth / (double) Nx;
		double Ry = screenHeight / (double) Ny;

		// calculate the distance that we need to move from Pc, A is right/left
		// and B is toward or back
		double A = ((x - (Nx / (double) 2)) * Rx) + (Rx / (double) 2);
		double B = ((y - (Ny / (double) 2)) * Ry) + (Ry / (double) 2);

		// calculate Pc
		Point3D tmpP = new Point3D(this._P0);
		Vector tmpV = new Vector(this._vTo);
		tmpV.scale(screenDist);
		tmpP.add(tmpV);
		Point3D Pc = new Point3D(tmpP);

		// calculate A*vRight into vRight and B*vUp into vUp
		vRight.scale(A);
		vUp.scale(B);

		// calculate vRight - vUp into vRight
		vRight.subtract(vUp);
		
		// calculate P, the point in the view plan the the ray pass there.
		Pc.add(vRight);
		Point3D P = new Point3D(Pc);

		// calculate the direction of the ray P-P0
		
		
		Point3D tmp = new Point3D(P);
		tmpV = new Vector(this._P0);
		tmp.subtract(tmpV);
		Vector direction = new Vector(tmp);

		// the final calculate- the ray.
		//return new Ray(this._P0, direction);
		return new Ray(P, direction);
	}
}
