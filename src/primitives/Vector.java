package primitives;
//
public class Vector implements Comparable<Vector> {

	private Point3D _head;

	// default cons
	public Vector() {
		_head = new Point3D();
	}

	// full cons
	public Vector(Point3D head) {
		_head = new Point3D(head);
	}

	public Vector(double x, double y, double z) {
		this._head = new Point3D(x, y, z);

	}

	// copy cons
	public Vector(Vector vector) {
		_head = new Point3D(vector._head);
	}
	
	//cons by 2 point
	public Vector(Point3D p1, Point3D p2)
	{
		double _x=p2._x.get_coordinate()-p1._x.get_coordinate();
		double _y=p2._y.get_coordinate()-p1._y.get_coordinate();
		double _z=p2.get_z().get_coordinate()-p1.get_z().get_coordinate();
				
		_head = new Point3D( _x,_y,_z);
	}

	// getter and setter

	public Point3D get_head() {
		return _head;
	}

	public void set_head(Point3D _head) {
		this._head = new Point3D(_head);
	}

	// compare the vectors = mean compare the 3D points, using the compareTo
	// from point3D class.
	@Override
	public int compareTo(Vector vector) {
		return this._head.compareTo(vector._head);
	}

	// print the object- the vector
	@Override
	public String toString() {
		return _head.toString();
	}

	// add- as usually x by x, y by y etc.
	public void add(Vector vector) {
		this._head._x.add(vector._head._x);
		this._head._y.add(vector._head._y);
		this._head.get_z().add(vector._head.get_z());
	}

	// Subtract- as usually x by x, y by y etc.
	public void subtract(Vector vector) {
		this._head._x.subtract(vector._head._x);
		this._head._y.subtract(vector._head._y);
		this._head.get_z().subtract(vector._head.get_z());

	}

	// vector cross product
	public Vector crossProduct(Vector vector) {

		Coordinate x = new Coordinate(this._head._y.get_coordinate() * vector._head.get_z().get_coordinate()
				- this._head.get_z().get_coordinate() * vector._head._y.get_coordinate());

		Coordinate y = new Coordinate(this._head.get_z().get_coordinate() * vector._head._x.get_coordinate()
				- this._head._x.get_coordinate() * vector._head.get_z().get_coordinate());

		Coordinate z = new Coordinate(this._head._x.get_coordinate() * vector._head._y.get_coordinate()
				- this._head._y.get_coordinate() * vector._head._x.get_coordinate());

		return new Vector(new Point3D(x, y, z));
	}

	// vector dot product
	public double dotProduct(Vector vector) {
		return (this._head._x.get_coordinate() * vector._head._x.get_coordinate()
				+ this._head._y.get_coordinate() * vector._head._y.get_coordinate()
				+ this._head.get_z().get_coordinate() * vector._head.get_z().get_coordinate());
	}

	// return the current vector
	public double length() {

		return Math.sqrt(Math.pow(this._head._x.get_coordinate(), 2) 
				+ Math.pow(this._head._y.get_coordinate(), 2)
				+ Math.pow(this._head.get_z().get_coordinate(), 2));

	}

	// normalize the current vector
	public void normalize() {

		// as the length is zero, we can not divided by 0
		if (this.length() == 0)
			throw new ArithmeticException("The vector size is zero");

		double old_length = this.length();
		this._head._x.set_coordinate(this._head._x.get_coordinate() / old_length);
		this._head._y.set_coordinate(this._head._y.get_coordinate() / old_length);
		this._head.get_z().set_coordinate(this._head.get_z().get_coordinate() / old_length);

	}

	// vector scalar multiplication
	public void scale(double scalingFactor) {

		this._head._x.set_coordinate(this._head._x.get_coordinate() * scalingFactor);
		this._head._y.set_coordinate(this._head._y.get_coordinate() * scalingFactor);
		this._head.get_z().set_coordinate(this._head.get_z().get_coordinate() * scalingFactor);

	}

}
