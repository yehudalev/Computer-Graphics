package primitives;

public class Point3D extends Point2D{
	
	private Coordinate _z;
		
	public Point3D() {
		
		_z=new Coordinate();
	}
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x,y);
		_z=new Coordinate(z);
		
	}
	
	public Point3D(double x,double y,double z)
	{
		this._x=new Coordinate(x);
		this._y=new Coordinate(y);
		this._z=new Coordinate(z);
		
		
	}
	
	public Point3D(Point3D point3D) {
		this(point3D._x,point3D._y,point3D._z);

	}
	
	
	
	public Coordinate get_z() {
		return _z;
	}
	
	public void set_z(Coordinate _z) {
		this._z = new Coordinate(_z);
	}	
	
	//////////@Override
	public int compareTo(Point3D point3D) {
		return(super.compareTo(point3D)+_z.compareTo(point3D._z));
		
	}
@Override
	public String toString() {
		return "( "+super.toString() + " , "+this._z.toString()+" )";
	}
	
	public void add(Vector vector) {
		
		this._x.add(vector.get_head()._x);
		this._y.add(vector.get_head()._y);
		this._z.add(vector.get_head()._z);
		
	}
	public void subtract(Vector vector) {
		
		this._x.subtract(vector.get_head()._x);
		this._y.subtract(vector.get_head()._y);
		this._z.subtract(vector.get_head()._z);
		
	}
	public double distance(Point3D point) {
		return 0;
	}

}
