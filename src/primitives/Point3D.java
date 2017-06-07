package primitives;
//
public class Point3D extends Point2D {

	private Coordinate _z;

	// default cons
	public Point3D() {

		_z = new Coordinate();
	}

	// full cons
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x, y);
		_z = new Coordinate(z);

	}

	public Point3D(double x, double y, double z) {
		this._x = new Coordinate(x);
		this._y = new Coordinate(y);
		this._z = new Coordinate(z);

	}

	// copy cons
	public Point3D(Point3D point3D) {
		this(point3D._x, point3D._y, point3D._z);

	}

	// getter and setter
	public Coordinate get_z() {
		return _z;
	}

	public void set_z(Coordinate _z) {
		this._z = new Coordinate(_z);
	}

	// Compare 2 points in 3D, either return 0 if both points are equal
	// or -1 or -2 or -3 if the points are different
	// @Override
	public int compareTo(Point3D point3D) {
		return (super.compareTo(point3D) + _z.compareTo(point3D._z));

	}

	// toString - print the point in 3D
	@Override
	public String toString() {
		return "( " + super.toString() + " , " + this._z.toString() + " )";
	}

	// class operations

	// add- add the parameter vector into current vector by x to x, y to y etc.

	public void add(Vector vector) {

		this._x.add(vector.get_head()._x);
		this._y.add(vector.get_head()._y);
		this._z.add(vector.get_head()._z);

	}

	// subtract- sub the from the current vector the parameter vector by x to x,
	// y to y etc.
	public void subtract(Vector vector) {

		this._x.subtract(vector.get_head()._x);
		this._y.subtract(vector.get_head()._y);
		this._z.subtract(vector.get_head()._z);

	}

	// NOT IMPLEMENT
	public double distance(Point3D point) {
		return Math.sqrt(Math.pow(this._x.get_coordinate()-point._x.get_coordinate(), 2)
				+Math.pow(this._y.get_coordinate()-point._y.get_coordinate(), 2)
				+Math.pow(this._z.get_coordinate()-point._z.get_coordinate(), 2));
	}

}
