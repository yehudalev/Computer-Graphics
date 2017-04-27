package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Ray_Test {

	@Test
	public void testToString() {
		Ray _Ray=new Ray(new Point3D(new Coordinate(3),new Coordinate(2),new Coordinate(4)),new Vector(new Point3D(new Coordinate(3),new Coordinate(3),new Coordinate(3))));
		
		assertEquals("Point: ( 3.00 , 2.00 , 4.00 )\nDirection: ( 3.00 , 3.00 , 3.00 )", _Ray.toString());
	}

	@Test
	public void testCompareTo() {
		Ray _Ray1=new Ray(new Point3D(new Coordinate(3),new Coordinate(2),new Coordinate(4)),new Vector(new Point3D(new Coordinate(3),new Coordinate(3),new Coordinate(3))));
		Ray _Ray2=new Ray(new Point3D(new Coordinate(3),new Coordinate(2),new Coordinate(4)),new Vector(new Point3D(new Coordinate(3),new Coordinate(3),new Coordinate(3))));
		
		assertEquals(0,_Ray1.compareTo(_Ray2));
	}

}
