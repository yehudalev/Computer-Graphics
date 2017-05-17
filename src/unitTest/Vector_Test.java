package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class Vector_Test {

	// test Add Between tow vectors-
	@Test
	public void testAdd() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(4)));

		vector1.add(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(3), new Coordinate(4), new Coordinate(5)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Add Between vector- end vector+
	@Test
	public void testAdd2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(9), new Coordinate(8), new Coordinate(7)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-3), new Coordinate(-4)));

		vector1.add(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(7), new Coordinate(5), new Coordinate(3)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Add Between tow vectors-
	@Test
	public void testAdd3() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(-9), new Coordinate(-8), new Coordinate(-7)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-3), new Coordinate(-4)));

		vector1.add(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(-11), new Coordinate(-11), new Coordinate(-11)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Add Between vector- end vector(0,0,0)
	@Test
	public void testAdd4() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(9), new Coordinate(8), new Coordinate(7)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));

		vector1.add(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(9), new Coordinate(8), new Coordinate(7)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Add Between tow vectors+-
	@Test
	public void testAdd5() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(9), new Coordinate(-8), new Coordinate(7)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(2), new Coordinate(-2)));

		vector1.add(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(7), new Coordinate(-6), new Coordinate(5)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Subtract Between tow vectors+
	@Test
	public void testSubtract() {

		Vector vector2 = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(4)));

		vector1.subtract(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(1), new Coordinate(2), new Coordinate(3)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Subtract Between vector- end vector+
	@Test
	public void testSubtract2() {

		Vector vector2 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-1), new Coordinate(-1)));
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(4)));

		vector1.subtract(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(3), new Coordinate(4), new Coordinate(5)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Subtract Between tow vectors-
	@Test
	public void testSubtract3() {

		Vector vector2 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-1), new Coordinate(-1)));
		Vector vector1 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-3), new Coordinate(-4)));

		vector1.subtract(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-2), new Coordinate(-3)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Subtract Between vector- end vector(0,0,0)
	@Test
	public void testSubtract4() {

		Vector vector2 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-1), new Coordinate(-1)));
		Vector vector1 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));

		vector1.subtract(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(1), new Coordinate(1), new Coordinate(1)));
		assertEquals(0, vector1.compareTo(result));
	}

	// test Subtract
	@Test
	public void testSubtract5() {

		Vector vector2 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(4), new Coordinate(-5)));
		Vector vector1 = new Vector(new Point3D(new Coordinate(4), new Coordinate(-3), new Coordinate(3)));

		vector1.subtract(vector2);
		Vector result = new Vector(new Point3D(new Coordinate(5), new Coordinate(-7), new Coordinate(8)));
		assertEquals(0, vector1.compareTo(result));
	}

	@Test
	// test Cross Product by vector+ * vector+
	public void testCrossProduct() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(4)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(1), new Coordinate(2), new Coordinate(3)));

		Vector result = new Vector(vector1.crossProduct(vector2));
		Vector exp = new Vector(new Point3D(new Coordinate(1), new Coordinate(-2), new Coordinate(1)));
		assertEquals(0, result.compareTo(exp));
	}

	@Test
	// test Cross Product by vector+ * vector-
	public void testCrossProduct2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(4)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-4), new Coordinate(-2), new Coordinate(-5)));

		Vector result = new Vector(vector1.crossProduct(vector2));
		Vector exp = new Vector(new Point3D(new Coordinate(-7), new Coordinate(-6), new Coordinate(8)));
		assertEquals(0, result.compareTo(exp));
	}

	@Test
	// test Cross Product by vector- * vector-
	public void testCrossProduct3() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-3), new Coordinate(-3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-4), new Coordinate(-2), new Coordinate(-5)));

		Vector result = new Vector(vector1.crossProduct(vector2));
		Vector exp = new Vector(new Point3D(new Coordinate(9), new Coordinate(2), new Coordinate(-8)));
		assertEquals(0, result.compareTo(exp));
	}

	@Test
	// test Cross Product by vector+ * vector(0,0,0)
	public void testCrossProduct4() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));

		Vector result = new Vector(vector1.crossProduct(vector2));
		Vector exp = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
		assertEquals(0, result.compareTo(exp));
	}

	@Test
	// test Dot Product by vector+ Dot vector+
	public void testDotProduct() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(1), new Coordinate(2), new Coordinate(3)));
		double result = vector1.dotProduct(vector2);
		assertEquals(17, result, 0.0001);
	}

	@Test
	// test Dot Product by vector+ Dot vector-
	public void testDotProduct2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-2), new Coordinate(-3)));
		double result = vector1.dotProduct(vector2);
		assertEquals(-17, result, 0.0001);
	}

	@Test
	// test Dot Product by vector- Dot vector-
	public void testDotProduct3() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-3), new Coordinate(-3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-2), new Coordinate(-3)));
		double result = vector1.dotProduct(vector2);
		assertEquals(17, result, 0.0001);
	}

	@Test
	// test Dot Product by vector- Dot vector(0,0,0)
	public void testDotProduct4() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-3), new Coordinate(-3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
		double result = vector1.dotProduct(vector2);
		assertEquals(0, result, 0.0001);
	}

	@Test
	// test Length by vector+
	public void testLength() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(1), new Coordinate(2)));
		double result = vector1.length();
		assertEquals(3, result, 0.0001);
	}

	@Test
	// test Length by vector(-,+,-)
	public void testLength2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(-3), new Coordinate(2), new Coordinate(-5)));
		double result = vector1.length();
		assertEquals(Math.sqrt(38), result, 0.0001);
	}

	@Test
	// test Length by vector(0,0,0)
	public void testLength3() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
		double result = vector1.length();
		assertEquals(0, result, 0.0001);
	}

	@Test
	// test Normalize vector+
	public void testNormalize() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(1), new Coordinate(2)));
		vector1.normalize();
		Vector vector2 = new Vector(
				new Point3D(new Coordinate(2 / 3f), new Coordinate(1 / 3f), new Coordinate(2 / 3f)));
		assertEquals(0, vector1.compareTo(vector2));
	}

	@Test
	// test Normalize vector-
	public void testNormalize2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-1), new Coordinate(-2)));
		vector1.normalize();
		Vector vector2 = new Vector(
				new Point3D(new Coordinate(-2 / 3f), new Coordinate(-1 / 3f), new Coordinate(-2 / 3f)));
		assertEquals(0, vector1.compareTo(vector2));
	}

	@Test
	// test Normalize vector(0,0,0)
	public void testNormalize3() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
		try {
			vector1.normalize();
			assertTrue(false);
		} catch (ArithmeticException e) {
			assertTrue(true);
		}

	}

	//// test Normalize vector by אלישי
	@Test
	public void testNormalize22() {
		Vector v = new Vector(3.5, -5, 10);
		v.normalize();
		assertEquals("", 1, v.length(), 1e-10);
		v = new Vector(0, 0, 0);
		try {
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	}

	@Test
	// test Scale by num+
	public void testScale() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(6)));
		vector1.scale(2);
		Vector vector2 = new Vector(new Point3D(new Coordinate(4), new Coordinate(6), new Coordinate(12)));
		assertEquals(0, vector1.compareTo(vector2));

	}

	@Test
	// test Scale by num-
	public void testScale2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(6)));
		vector1.scale(-2);
		Vector vector2 = new Vector(new Point3D(new Coordinate(-4), new Coordinate(-6), new Coordinate(-12)));
		assertEquals(0, vector1.compareTo(vector2));

	}

	@Test
	// test Scale by zero
	public void testScale3() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(6)));
		vector1.scale(0);
		Vector vector2 = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
		assertEquals(0, vector1.compareTo(vector2));

	}

	@Test
	// test Scale by 1
	public void testScale4() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(6)));
		vector1.scale(1);
		Vector vector2 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(6)));
		assertEquals(0, vector1.compareTo(vector2));

	}

	// test CompareTo
	@Test
	public void testCompareTo() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(2), new Coordinate(3), new Coordinate(3)));

		assertEquals(0, vector1.compareTo(vector2));
	}

	// test CompareTo
	@Test
	public void testCompareTo2() {
		Vector vector1 = new Vector(new Point3D(new Coordinate(2.999999), new Coordinate(6.5), new Coordinate(-3)));
		Vector vector2 = new Vector(new Point3D(new Coordinate(3), new Coordinate(6.4999999), new Coordinate(-3)));

		assertEquals(0, vector1.compareTo(vector2));
	}

	// test ToString
	@Test
	public void testToString() {
		Vector vector1 = new Vector(
				new Point3D(new Coordinate(2.999999), new Coordinate(6.499999), new Coordinate(-3)));
		assertEquals("( 3.00 , 6.50 , -3.00 )", vector1.toString());

	}

	////// tests by david chean

	@Test
	public void Test06() {
		System.out.println("Test06: Vector Add test");
		Vector v1 = new Vector(new Point3D(new Coordinate(1.0), new Coordinate(1.0), new Coordinate(1.0)));
		Vector v2 = new Vector(new Point3D(new Coordinate(-1.0), new Coordinate(-1.0), new Coordinate(-1.0)));
		v1.add(v2);
		assertTrue(v1.compareTo(
				new Vector(new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(0.0)))) == 0);

		v2.add(v1);
		assertTrue(v2.compareTo(v2) == 0);
	}

	@Test
	public void Test07() {
		System.out.println("Test07: Vector Substruct test");

		Vector v1 = new Vector(new Point3D(new Coordinate(1.0), new Coordinate(1.0), new Coordinate(1.0)));
		Vector v2 = new Vector(new Point3D(new Coordinate(-1.0), new Coordinate(-1.0), new Coordinate(-1.0)));

		v1.subtract(v2);
		assertTrue(v1.compareTo(
				new Vector(new Point3D(new Coordinate(2.0), new Coordinate(2.0), new Coordinate(2.0)))) == 0);

		v2.subtract(v1);
		assertTrue(v2.compareTo(
				new Vector(new Point3D(new Coordinate(-3.0), new Coordinate(-3.0), new Coordinate(-3.0)))) == 0);

	}

	@Test
	public void Test08() {
		System.out.println("Test08: Vector Scaling test");

		Vector v1 = new Vector(new Point3D(new Coordinate(1.0), new Coordinate(1.0), new Coordinate(1.0)));

		v1.scale(1);
		assertTrue(v1.compareTo(v1) == 0);

		v1.scale(2);
		assertTrue(v1.compareTo(
				new Vector(new Point3D(new Coordinate(2.0), new Coordinate(2.0), new Coordinate(2.0)))) == 0);

		v1.scale(-2);
		assertTrue(v1.compareTo(
				new Vector(new Point3D(new Coordinate(-4.0), new Coordinate(-4.0), new Coordinate(-4.0)))) == 0);
	}

	@Test
	public void Test09() {
		System.out.println("Test09: Vector Dot product test");
		Vector v1 = new Vector(new Point3D(new Coordinate(3.5), new Coordinate(-5), new Coordinate(10)));
		Vector v2 = new Vector(new Point3D(new Coordinate(2.5), new Coordinate(7), new Coordinate(0.5)));

		assertTrue(Double.compare(v1.dotProduct(v2), (8.75 + -35 + 5)) == 0);

	}

	@Test
	public void Test10() {
		System.out.println("Test10: Vector Length test");

		Vector v = new Vector(new Point3D(new Coordinate(3.5), new Coordinate(-5), new Coordinate(10)));

		assertTrue(v.length() == Math.sqrt(12.25 + 25 + 100));
	}

	@Test
	public void Test11() {
		System.out.printf("Test11: Vector Normalize test -> ");

		Vector v = new Vector(new Point3D(new Coordinate(100), new Coordinate(-60.781), new Coordinate(0.0001)));

		System.out.printf("Length = %f  ", v.length());
		v.normalize();
		System.out.printf("Length = %f\n", v.length());

		assertEquals("Incorrect length after normalize! ", 1, v.length(), 1e-10);

		v = new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));

		try {
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} catch (ArithmeticException e) {
			assertTrue(true);
		}

	}

	@Test
	public void Test12() {
		System.out.println("Test12: Vector Cross product test");

		Vector v1 = new Vector(new Point3D(new Coordinate(3.5), new Coordinate(-5.0), new Coordinate(10.0)));
		Vector v2 = new Vector(new Point3D(new Coordinate(2.5), new Coordinate(7), new Coordinate(0.5)));

		Vector v3 = v1.crossProduct(v2);

		assertEquals("", 0, v3.dotProduct(v2), 1e-10);
		assertEquals("", 0, v3.dotProduct(v1), 1e-10);

		Vector v4 = v2.crossProduct(v1);
		v3.add(v4);
		assertEquals("", 0, v3.length(), 1e-10);
	}

	/*
	 * package Primitives;
	 * 
	 * import org.junit.jupiter.api.Test;
	 * 
	 * import static org.junit.jupiter.api.Assertions.*;
	 * 
	 */
	/**
	 * Created by ×�×œ×™ ×œ on 24/04/2017.
	 */

	@Test
	public void add() {
		Vector V1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(2)));
		Vector V2 = new Vector(new Point3D(new Coordinate(3), new Coordinate(3), new Coordinate(3)));

		System.out.println(V1);
		V1.add(V2);
		Vector V5 = new Vector(new Point3D(new Coordinate(5), new Coordinate(5), new Coordinate(5)));
		System.out.println(V1.toString());
		assertEquals(V1.toString(), V5.toString());
	}

	@Test
	public void subtract() {

		Vector V1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(2)));
		Vector V2 = new Vector(new Point3D(new Coordinate(3), new Coordinate(3), new Coordinate(3)));

		System.out.println(V1);
		V1.subtract(V2);
		Vector V5 = new Vector(new Point3D(new Coordinate(-1), new Coordinate(-1), new Coordinate(-1)));
		System.out.println(V1.toString());
		assertEquals(V1.toString(), V5.toString());
	}

	@Test
	public void scale() {
		Vector V1 = new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(2)));
		double a = -1;
		V1.scale(a);
		Vector VResult = new Vector(new Point3D(new Coordinate(-2), new Coordinate(-2), new Coordinate(-2)));
		assertEquals(V1.toString(), VResult.toString());
	}
	
	  @Test
	    public void Test05() {
	        System.out.println("Test05: Point3D distance");
	        Point3D point = new Point3D(-20.5, 55, 9.25);
	        Point3D instance = new Point3D(75, -10, -100);
	        double expResult = 159.0;
	        double result = instance.distance(point);
	        assertEquals( "Worng distance",expResult, result, 0.01);

	    }
}
