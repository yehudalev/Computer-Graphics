package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class Point3D_Test {

	// testTo String
	@Test
	public void testToString() {
		Point3D point3D = new Point3D(new Coordinate(2.999999), new Coordinate(6.499999), new Coordinate(-3));
		assertEquals("( 3.00 , 6.50 , -3.00 )", point3D.toString());

	}

	// test CompareTo Point3D
	@Test
	public void testCompareToPoint3D() {
		Point3D point1 = new Point3D(new Coordinate(2.999999), new Coordinate(6.4499999), new Coordinate(-3));
		Point3D point2 = new Point3D(new Coordinate(3), new Coordinate(6.45), new Coordinate(-3));

		assertEquals(0, point1.compareTo(point2));
	}

	// test Add: Between two vectors
	@Test
	public void testAdd() {
		Point3D point1 = new Point3D(new Coordinate(2.35), new Coordinate(6.4999999), new Coordinate(-3));
		Vector vec = new Vector(new Point3D(new Coordinate(3.65), new Coordinate(3.2), new Coordinate(-3)));

		Point3D result = new Point3D(new Coordinate(6), new Coordinate(9.7), new Coordinate(-6));
		point1.add(vec);
		assertEquals(0, point1.compareTo(result));
	}

	// test Subtract: Between point to vector
	@Test
	public void testSubtract() {
		Point3D point1 = new Point3D(new Coordinate(5.3), new Coordinate(6.4999999), new Coordinate(-3));
		Vector vec = new Vector(new Point3D(new Coordinate(3.9), new Coordinate(3.2), new Coordinate(-3)));

		Point3D result = new Point3D(new Coordinate(1.4), new Coordinate(3.3), new Coordinate(0));
		point1.subtract(vec);
		assertEquals(0, point1.compareTo(result));
	}

	// test Distance:Between two pointD3
	@Test
	public void testDistance() {
		Point3D point1 = new Point3D(new Coordinate(4.5), new Coordinate(3), new Coordinate(2));
		Point3D point2 = new Point3D(new Coordinate(3), new Coordinate(6), new Coordinate(-3));

		double exp = 6.02;
		double result = point1.distance(point2);
		assertEquals(exp, result, 0.01);

	}

	///////////// test by david chean

	@Test
	public void Test01ComparTo() {
		System.out.println("Test01: Point3D compareTo");
		Point3D point3D = new Point3D(new Coordinate(2.0), new Coordinate(-7.5), new Coordinate(9.25));
		Point3D instance = new Point3D(new Coordinate(2.0), new Coordinate(-7.5), new Coordinate(9.25));
		int expResult = 0;
		int result = instance.compareTo(point3D);
		assertEquals(expResult, result);
	}

	@Test
	public void Test02() {
		System.out.println("Test02: Point3D toString");
		Point3D instance = new Point3D(new Coordinate(1.123), new Coordinate(2.569), new Coordinate(3.999));
		String expResult = "( 1.12 , 2.57 , 4.00 )";
		String result = instance.toString();
		assertEquals(expResult, result);
	}

	@Test
	public void Test03() {
		System.out.println("Test03: Point3D add");
		Vector vector = new Vector(new Point3D(new Coordinate(1.25), new Coordinate(-2.0), new Coordinate(3.0)));
		Point3D instance = new Point3D(new Coordinate(4.75), new Coordinate(-5.0), new Coordinate(6.0));
		instance.add(vector);
		assertTrue("Add failed! ",
				(instance.compareTo(new Point3D(new Coordinate(6.0), new Coordinate(-7.0), new Coordinate(9.0))) == 0));

	}

	@Test
	public void Test04() {
		System.out.println("Test04: Point3D subtract");
		Vector vector = new Vector(1.0, 2.0, 3.0);
		Point3D instance = new Point3D(4.0, 5.0, 6.0);
		instance.subtract(vector);
		assertTrue("Substruct failed! ", instance.compareTo(new Point3D(3.0, 3.0, 3.0)) == 0);
	}

	@Test
	public void Test05() {
		System.out.println("Test05: Point3D distance");
		Point3D point = new Point3D(-20.5, 55, 9.25);
		Point3D instance = new Point3D(75, -10, -100);
		double expResult = 159.0;
		double result = instance.distance(point);
		assertEquals(expResult, result, 0.01);

	}

}
