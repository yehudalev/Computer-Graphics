package unitTest;

import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTests{

	@Test
	public void basicRendering() {

		Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0, 0, 0), new Camera(), 40);

		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));

		Triangle triangle = new Triangle(new Point3D(100, 0, -49), new Point3D(0, 100, -49),
				new Point3D(100, 100, -49));

		Triangle triangle2 = new Triangle(new Point3D(100, 0, -49), new Point3D(0, -100, -49),
				new Point3D(100, -100, -49));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49), new Point3D(0, 100, -49),
				new Point3D(-100, 100, -49));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49), new Point3D(0, -100, -49),
				new Point3D(-100, -100, -49));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("AmbientLight Test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		// render.printGrid(50);
		render.writeToImage();

	}
	
	@Test
	public void basicRendering1() {

		Scene scene = new Scene();

		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -150)));

		Triangle triangle = new Triangle(new Point3D(100, 0, -149), new Point3D(0, 100, -149),
				new Point3D(100, 100, -149));

		Triangle triangle2 = new Triangle(new Point3D(100, 0, -149), new Point3D(0, -100, -149),
				new Point3D(100, -100, -149));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -149), new Point3D(0, 100, -149),
				new Point3D(-100, 100, -149));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149), new Point3D(0, -100, -149),
				new Point3D(-100, -100, -149));

		// add emotion to each geometric

		triangle.set_emmission(new Color(51, 255, 51));
		triangle2.set_emmission(new Color(102, 255, 102));
		triangle4.set_emmission(new Color(255, 102, 102));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Emmision Test", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}

}
