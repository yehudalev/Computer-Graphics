package geometries;

import primitives.*;

public class Triangle {
	
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;
	
	//Default cons 
	public Triangle() {
		this._p1=new Point3D();
		this._p2=new Point3D();
		this._p3=new Point3D();
	}
	
	//copy cons 
	public Triangle(Triangle triangle){
		this._p1=new Point3D(triangle._p1);
		this._p2=new Point3D(triangle._p2);
		this._p3=new Point3D(triangle._p3);
	}
	
	//full cons
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		this._p1=new Point3D(p1);
		this._p2=new Point3D(p2);
		this._p3=new Point3D(p3);
	}
	
	//getters
	public Point3D get_p1() {
		return _p1;
	}
	
	public Point3D get_p2() {
		return _p2;
	}
	
	public Point3D get_p3() {
		return _p3;
	}
	
	//setters 
	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}
	
	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}
	
	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}
}
