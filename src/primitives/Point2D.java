package primitives;
//
public class Point2D implements Comparable<Point2D> {

	protected Coordinate _x;
	protected Coordinate _y;

	// Default cons
	public Point2D() {
		this._x = new Coordinate();
		this._y = new Coordinate();
	}

	// full cons
	public Point2D(Coordinate x, Coordinate y) {

		this._x = new Coordinate(x);
		this._y = new Coordinate(y);
	}

	// copy cons
	public Point2D(Point2D point2D) {

		this(point2D._x, point2D._y);
	}

	// getters and setters
	public Coordinate getX() {
		return _x;
	}

	public Coordinate getY() {
		return _y;
	}

	public void setX(Coordinate _x) {
		this._x = new Coordinate(_x);
	}

	public void setY(Coordinate _y) {
		this._y = new Coordinate(_y);
	}

	// toString - print the point in 2D
	@Override
	public String toString() {
		return String.format(this._x.toString() + " , " + this._y.toString());
	}

	// Compare 2 points in 2D, either return 0 if both points are equal
	// or -1 or -2 if the points are different
	@Override
	public int compareTo(Point2D point2D) {
		return (_x.compareTo(point2D._x) + _y.compareTo(point2D._y));

	}

}
