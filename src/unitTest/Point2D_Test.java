package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point2D;
import primitives.*;
public class Point2D_Test {
	
	
	//toString Test
	@Test
	public void toStringTest() {
		Point2D point2d1 = new Point2D(new Coordinate(11.8911),new Coordinate(11.4699999));
	    String slu=	point2d1.toString();
	    assertEquals( "11.89 , 11.47", slu);
	}
	
	//compareTo Test
	@Test
	public void compareToTest() {
		Point2D point2d1 = new Point2D(new Coordinate(11.899999),new Coordinate(11.29999)); 
		Point2D point2d2 = new Point2D(new Coordinate(11.9),new Coordinate(11.3));
		
		int sul= point2d1.compareTo(point2d2);
		assertEquals(0, sul,0.00001);
	}
	
	//compareTo Test
	@Test
	public void compareToTest2() {
		Point2D point2d1 = new Point2D(new Coordinate(11.89),new Coordinate(11.29999)); 
		Point2D point2d2 = new Point2D(new Coordinate(11.9),new Coordinate(11.3));
		
		int sul= point2d1.compareTo(point2d2);
		assertEquals(-1, sul,0.00001);
	}
}
