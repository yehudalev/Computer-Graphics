package unitTest;

import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import elements.PointLight;

import elements.SpotLight;

import geometries.Sphere;

import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;

import primitives.Vector;

import renderer.ImageWriter;

import renderer.Render;

import scene.Scene;


//those tests are also test the Phong Model
public class Render_Lights_Tests {

	@Test
	public void testRenderImage1() throws Exception {
		Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0, 1, 0), new Vector(0, 0, -1));
		Scene scene = new Scene(new AmbientLight(255, 255, 255), new Color(0, 0, 0), camera, 100);

		Sphere sphere1 = new Sphere(900.0, new Point3D(0.0, 0.0, -1300.0));
		sphere1.set_nShininess(35);
		sphere1.set_emmission(new Color(17, 15, 116));
		sphere1.set_material(new Material(1, 1, 0, 1, 0));

		scene.addGeometry(sphere1);

		scene.addLight(
				new PointLight(new Color(255, 50, 50), new Point3D(200.0, 200.0, -20.0), 0.000004, 0.000004, 0.000002));

		ImageWriter imageWriter = new ImageWriter("1.Point Light Test 1", 500, 500, 500, 500);
		Render render = new Render(imageWriter, scene);
		render.renderImage();
		render.writeToImage();
	}

	@Test
	public void testRenderImage2() {

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("2.Point Light Test 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}
	
	@Test
	public void testRenderImage3() {

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), new Vector(2, 2, -3), 0,
				0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("3.Spot Light Test 2", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}
	
	@Test
	public void testRenderImage4(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));

		Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, -3500, -1000),
				new Point3D(3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, 3500, -1000),
				new Point3D(-3500, -3500, -1000));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005));

		ImageWriter imageWriter = new ImageWriter("4.Point Light Test 3", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}
	
	@Test
	public void testRenderImage5(){

		Scene scene = new Scene();
		Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
		sphere.set_nShininess(20);
		sphere.set_emmission(new Color(0, 0, 100));

		Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, -3500, -1000),
				new Point3D(3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000), new Point3D(-3500, 3500, -1000),
				new Point3D(-3500, -3500, -1000));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), new Vector(0, 0, -1), 0, 0.000001, 0.0000005));

		ImageWriter imageWriter = new ImageWriter("5.Spot Light Test 3", 500, 500, 500, 500);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.writeToImage();

	}
	
	@Test
	public void spotLightTest3(){

	    Scene scene = new Scene();

	    Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
	            new Point3D( -3500, -3500, -1000),
	            new Point3D(  3500, -3500, -2000));

	    Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
	            new Point3D( -3500,  3500, -1000),
	            new Point3D( -3500, -3500, -1000));

	    scene.addGeometry(triangle);
	    scene.addGeometry(triangle2);

	    scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(180, 180, -10),
	            new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));

	    Sphere sphere = new Sphere (800, new Point3D(0.0, 0.0, -1000));
	    sphere.set_nShininess(20);
	    sphere.set_emmission(new Color(0, 0, 100));
	    scene.addGeometry(sphere);

	    ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

	    Render render = new Render(imageWriter, scene);

	    render.renderImage();
	    render.writeToImage();

	}
	
	@Test

	public void spotLightTest2(){


		Scene scene = new Scene();

		scene.setScreenDistance(200);

		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));

		sphere.set_nShininess(20);

		sphere.set_emmission(new Color(0, 0, 100));

		scene.addGeometry(sphere);


		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),

				new Point3D(-225, -125, -260),

				new Point3D(-225, -225, -270));


		triangle.set_emmission(new Color (0, 0, 100));

		triangle.set_nShininess(4);

		scene.addGeometry(triangle);


		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

		

		ImageWriter imageWriter = new ImageWriter("Spot lighting test 22222", 500, 500, 500, 500);


		Render render = new Render(imageWriter, scene);


		render.renderImage();

		render.writeToImage();


	}
	
	@Test

	public void spotLightTest35(){


		Scene scene = new Scene();

		scene.setScreenDistance(200);

		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));

		sphere.set_nShininess(20);

		sphere.set_emmission(new Color(0, 0, 100));

		scene.addGeometry(sphere);


		Triangle triangle = new Triangle(new Point3D(-125, -225, -350),

				new Point3D(-225, -125, -350),

				new Point3D(-225, -225, -360));


		triangle.set_emmission(new Color (0, 0, 100));

		triangle.set_nShininess(4);

		scene.addGeometry(triangle);


		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

		

		ImageWriter imageWriter = new ImageWriter("Spot lighting test 33333", 500, 500, 500, 500);


		Render render = new Render(imageWriter, scene);


		render.renderImage();

		render.writeToImage();


	}
	
	
	@Test

	public void peramida(){


		Scene scene = new Scene();

		scene.setScreenDistance(200);

		Triangle floor1 =new Triangle(new Point3D(0, 0, -1500), new Point3D(-100, 0, -1250), new Point3D(100, 0, -1250));
		Triangle floor2 =new Triangle(new Point3D(0, 0, -1000), new Point3D(-100, 0, -1250), new Point3D(100, 0, -1250));
		
		Triangle tri1 =new Triangle(new Point3D(0, 0, -1500), new Point3D(100, 0, -1250), new Point3D(0, 100, -1250));
		Triangle tri2 =new Triangle(new Point3D(0, 0, -1500), new Point3D(-100, 0, -1250), new Point3D(0, 100, -1250));
		Triangle tri3 =new Triangle(new Point3D(0, 0, -1000), new Point3D(-100, 0, -1250), new Point3D(0, 100, -1250));
		Triangle tri4 =new Triangle(new Point3D(100, 0, -100), new Point3D(100, 0, -1250), new Point3D(0, 100, -1250));
		
		
		
		
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		
		
		

		sphere.set_nShininess(20);

		sphere.set_emmission(new Color(0, 0, 100));

		scene.addGeometry(sphere);


		Triangle triangle = new Triangle(new Point3D(-125, -225, -350),

				new Point3D(-225, -125, -350),

				new Point3D(-225, -225, -360));


		triangle.set_emmission(new Color (0, 0, 100));

		triangle.set_nShininess(4);

		scene.addGeometry(triangle);


		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

				new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

		

		ImageWriter imageWriter = new ImageWriter("Spot lighting test 33333", 500, 500, 500, 500);


		Render render = new Render(imageWriter, scene);


		render.renderImage();

		render.writeToImage();


	}
}