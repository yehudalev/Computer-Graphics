/**
 * 
 */
package primitives;

/**
 * @author DOVI
 *
 */
public class ssss {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double x=11.8911;
		double y=11.2934;
		
		double s=x+y;
		System.out.println(String.format("("+" %.2f " + ","+" %.2f "+ ")",x,y));
		System.out.println(s+"\n sssssss");
		
		Point3D point1= new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4));
		System.out.println(point1.toString());
		
		
		
		Vector vector1=new Vector(new Point3D(new Coordinate(2),new Coordinate(3),new Coordinate(4)));
		Vector vector2=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		
		vector1.crossProduct(vector2);
		Vector result=new Vector(new Point3D(new Coordinate(2),new Coordinate(-2),new Coordinate(1)));
		System.out.println(vector1.toString());
		System.out.println(result.toString());
		
		Vector vector11=new Vector(new Point3D(new Coordinate(2),new Coordinate(1),new Coordinate(2)));
		
		System.out.println(vector11.length());
		
		Vector vector222=new Vector(new Point3D(new Coordinate(2/3f),new Coordinate(1/3f),new Coordinate(2/3f)));
		Vector vector22=new Vector(new Point3D(new Coordinate(2),new Coordinate(1),new Coordinate(2)));
		vector22.normalize();
		System.out.println(vector22.toString());
		System.out.println(vector222.toString());
	}

}
