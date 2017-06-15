package primitives;

//
public class Ray implements Comparable<Ray> {

	private Point3D _POO;
	private Vector _direction;

	// default cons
	public Ray() {
		_POO = new Point3D();
		_direction = new Vector();

	}

	// copy cons
	public Ray(Ray ray) {
		this(ray._POO, ray._direction);
	}

	// full cons
	public Ray(Point3D poo, Vector direction) {
		_POO = new Point3D(poo);
		_direction = new Vector(direction);
		_direction.normalize();
	}

	// getters and setters
	public Point3D get_POO() {
		return _POO;
	}

	public void set_POO(Point3D _POO) {
		this._POO = new Point3D(_POO);
	}

	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = new Vector(_direction);
		_direction.normalize();
	}

	// toString - print the point in Ray
	@Override
	public String toString() {
		return "Point: " + _POO.toString() + "\nDirection: " + _direction.toString();
	}

	// Compare 2 Ray
	@Override
	public int compareTo(Ray ray) {

		return (this._POO.compareTo(ray._POO) + this._direction.compareTo(ray._direction));
	}
}
