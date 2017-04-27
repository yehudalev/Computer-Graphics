package primitives;

public class Vector implements Comparable<Vector>{
	private  Point3D _head;
	
	public Vector() {
		_head=new Point3D();
	}
	public Vector(Point3D head) {
		_head=new Point3D(head);
	}
	//copy cons
	public Vector(Vector vector) {
	_head=new Point3D(vector._head);
	}
	
	public Vector(double x,double y,double z)
	{
	     this._head= new Point3D(x,y,z);
		
	}


	public Point3D get_head() {
		return _head;
	}
	public void set_head(Point3D _head) {
		this._head = new Point3D(_head);
	}
	 @Override
	public int compareTo(Vector vector) {
		return this._head.compareTo(vector._head);
	}
	 @Override
	public String toString() {
		 return _head.toString();
	}
	public void add(Vector vector) {
		this._head._x.add(vector._head._x);
		this._head._y.add(vector._head._y);
		this._head.get_z().add(vector._head.get_z());
	}
	public void subtract(Vector vector) {
		this._head._x.subtract(vector._head._x);
		this._head._y.subtract(vector._head._y);
		this._head.get_z().subtract(vector._head.get_z());
		
	}
	public Vector crossProduct(Vector vector) {
		
		Coordinate x=new Coordinate(this._head._y.get_coordinate()*vector._head.get_z().get_coordinate()
				-this._head.get_z().get_coordinate()*vector._head._y.get_coordinate());
		
		Coordinate y=new Coordinate(this._head.get_z().get_coordinate()*vector._head._x.get_coordinate()
				-this._head._x.get_coordinate()*vector._head.get_z().get_coordinate());
		
		Coordinate z=new Coordinate(this._head._x.get_coordinate()*vector._head._y.get_coordinate()
				-this._head._y.get_coordinate()*vector._head._x.get_coordinate());
		
		
		return new Vector(new Point3D(x,y,z));
	}
	
	public double dotProduct(Vector vector) {
		return (this._head._x.get_coordinate()*vector._head._x.get_coordinate()
				+this._head._y.get_coordinate()*vector._head._y.get_coordinate()
				+this._head.get_z().get_coordinate()*vector._head.get_z().get_coordinate());
	}
	
	public double length() {
		
		return Math.sqrt(Math.pow(this._head._x.get_coordinate(),2)+
				Math.pow(this._head._y.get_coordinate(),2)+
				Math.pow(this._head.get_z().get_coordinate(),2));
		
	}
	
	public void normalize() {
		
		if(this.length()==0)
			throw new ArithmeticException("The vector size is zero");
		
		double old_length=this.length();
		this._head._x.set_coordinate(this._head._x.get_coordinate()/old_length);
		this._head._y.set_coordinate(this._head._y.get_coordinate()/old_length);
		this._head.get_z().set_coordinate(this._head.get_z().get_coordinate()/old_length);
		
	}
	
	public void scale(double scalingFactor) {
		
		this._head._x.set_coordinate(this._head._x.get_coordinate()*scalingFactor);
		this._head._y.set_coordinate(this._head._y.get_coordinate()*scalingFactor);
		this._head.get_z().set_coordinate(this._head.get_z().get_coordinate()*scalingFactor);
		
	}
	
	
	

}
