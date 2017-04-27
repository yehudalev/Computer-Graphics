package unitTest;
import primitives.*;

import static org.junit.Assert.*;



import org.junit.Test;

public class CoordinateTest {

	@Test
	public void compareToTest() {
		Coordinate coordinate1=new Coordinate(11.89999);
		Coordinate coordinate2=new Coordinate(11.9);
		
		int s=coordinate1.compareTo(coordinate2);
		
		assertEquals(0, s);
		
	}
	@Test
	public void compareToTest2() {
		Coordinate coordinate1=new Coordinate(11.9);
		Coordinate coordinate2=new Coordinate(11.89999);
		
		int s=coordinate1.compareTo(coordinate2);
		
		assertEquals(0, s);		
	}
	
	@Test
	public void compareToTest3() {
		Coordinate coordinate1=new Coordinate(11.3899);
		Coordinate coordinate2=new Coordinate(11.4);
		
		int s=coordinate1.compareTo(coordinate2);
		
		assertEquals(-1, s);		
	}
	@Test
	public void addTest() {
		Coordinate coordinate1=new Coordinate(11.5);
		Coordinate coordinate2=new Coordinate(11.4);
		
		coordinate1.add(coordinate2);
		assertEquals(22.9, coordinate1.get_coordinate(),0.0001);
    }
	
	@Test
	public void addTest2() {
		Coordinate coordinate1=new Coordinate(11.5);
		Coordinate coordinate2=new Coordinate(-10.3);
		
		coordinate1.add(coordinate2);
		assertEquals(1.2, coordinate1.get_coordinate(),0.0001);
	}
	@Test
	public void subtractTest() {
		Coordinate coordinate1=new Coordinate(11.5);
		Coordinate coordinate2=new Coordinate(11.3);
		
		coordinate1.subtract(coordinate2);
		assertEquals(0.2, coordinate1.get_coordinate(),0.0001);
	}
	@Test
	public void subtractTest2() {
		Coordinate coordinate1=new Coordinate(11.5);
		Coordinate coordinate2=new Coordinate(-11.3);
		
		coordinate1.subtract(coordinate2);
		assertEquals(22.8, coordinate1.get_coordinate(),0.0001);
	}
	@Test
	public void toStringTest() {
		Coordinate coordinate1=new Coordinate(11.55111);
		assertEquals("11.55",coordinate1.toString());
    }
}
