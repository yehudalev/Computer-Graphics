package geometries;

import primitives.*;
public class Sphere extends RadialGeometry {
	private Point3D _center;

	//default cons
	public Sphere(){
		super();
		this._center=new Point3D();
	}
	
	//copy cons
	public Sphere (Sphere sphere){
		super(sphere._radius);
		this._center=new Point3D(sphere._center);
	}
	
	//full cons
	public Sphere(double radius, Point3D center){
		super(radius);
		this._center=new Point3D(center);
	}
		
	//getter
	public Point3D getCenter() {
		return _center;
	}

	//setter 
	public void setCenter(Point3D _center) {
		this._center = new Point3D(_center);
	}

}
