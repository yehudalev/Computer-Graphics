package geometries;
import primitives.*;
import primitives.Point3D;
import java.util.List;

public interface Geometry {

	public abstract List<Point3D> FindIntersections (Ray ray);
	public abstract Vector getNormal(Point3D point);
}
