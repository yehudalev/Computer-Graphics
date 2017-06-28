  package unitTest;

import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import geometries.*;
import elements.*;
import scene.*;
import java.awt.Color;

import org.junit.Test;



public class Reflected_Refracted{

	            

	 
	 
	 @Test
	 public void shadowTest1(){
	  
	  Scene scene = new Scene();
	  Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
	  sphere.set_nShininess(20);
	  sphere.set_emmission(new Color(0, 0, 100));
	  
	  scene.addGeometry(sphere);
	  
	  Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
	            new Point3D( -3500, -3500, -1000),
	            new Point3D(  3500, -3500, -2000));

	  Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
	              new Point3D( -3500,  3500, -1000),
	              new Point3D( -3500, -3500, -1000));
	  
	  scene.addGeometry(triangle);
	  scene.addGeometry(triangle2);
	  
	  scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
	       new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
	 
	  
	  ImageWriter imageWriter = new ImageWriter("Shadow test1", 500, 500, 500, 500);
	  
	  Render render = new Render(imageWriter, scene);
	  
	  render.renderImage();
	  render.writeToImage();
	  
	 }
	 
	 @Test
		public void shadowTest2(){

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

		    ImageWriter imageWriter = new ImageWriter("Shadow test2", 500, 500, 500, 500);

		    Render render = new Render(imageWriter, scene);

		    render.renderImage();
		    render.writeToImage();

		}
	 
	 @Test
		public void RRTest0(){
			
			Scene scene = new Scene();
			scene.setScreenDistance(150);
			
			
			
			Sphere sphere = new Sphere(150, new Point3D(-300, -500, -1050));
			sphere.set_nShininess(20);
			sphere.set_emmission(new Color(0, 255, 0));
			scene.addGeometry(sphere);
			
			
			Sphere sphere1 = new Sphere(150, new Point3D(-600, -500, -1050));
			sphere1.set_nShininess(20);
			sphere1.set_emmission(new Color(0, 0, 100));
			scene.addGeometry(sphere1);
			
			
			Sphere sphere2 = new Sphere(150, new Point3D(0, -500, -1050));
			sphere2.set_nShininess(20);
			sphere2.set_emmission(new Color(255, 0, 0));
			scene.addGeometry(sphere2);
			
			
			Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
					 						 new Point3D( -1500,  1500, -1500),
					 						 new Point3D(  200,  200, -375));
			
			Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
											  new Point3D( -1500,  1500, -1500),
											  new Point3D( -1500, -1500, -1500));
			
			Triangle triangle3 = new Triangle(new Point3D(   -1500,  1500, -1500),
					  new Point3D(  -1500, -1500, -1500),
					  new Point3D( -1000, 1500, -1000));
			triangle3.set_emmission(new Color(20, 20, 20));
			triangle3.setKr(0.5);
			scene.addGeometry(triangle3);
			
			
			triangle.set_emmission(new Color(20, 20, 20));
			triangle2.set_emmission(new Color(20, 20, 20));
			triangle.setKr(1);
			triangle2.setKr(0.5);
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);

			scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
					   new Vector(0, 0, 0), 0.000005, 0.000005, 0.000005));
		
			ImageWriter imageWriter = new ImageWriter("RRTest0", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter, scene);
			
			render.renderImage();
			render.writeToImage();
			
		}
	 
	 @Test
		public void RRTest1(){
			
			Scene scene = new Scene();
			scene.setScreenDistance(300);
			
			Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
			sphere.set_nShininess(20);
			sphere.set_emmission(new Color(0, 0, 100));
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
			sphere2.set_nShininess(20);
			sphere2.set_emmission(new Color(100, 20, 20));
			scene.addGeometry(sphere2);
			
			Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
					 						 new Point3D( -1500,  1500, -1500),
					 						 new Point3D(  200,  200, -375));
			
			Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
											  new Point3D( -1500,  1500, -1500),
											  new Point3D( -1500, -1500, -1500));
			
			triangle.set_emmission(new Color(20, 20, 20));
			triangle2.set_emmission(new Color(20, 20, 20));
			triangle.setKr(1);
			triangle2.setKr(0.5);
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);

			scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
					   new Vector(-1, -1, -2), 0, 0.00001, 0.000005));
		
			ImageWriter imageWriter = new ImageWriter("RR and Shadow Test1", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter, scene);
			
			render.renderImage();
			render.writeToImage();
			
		}
		
		@Test
		public void RRTest2(){
			
			Scene scene = new Scene();
			scene.setScreenDistance(300);
			
			Sphere sphere = new Sphere(150, new Point3D(-300, -500, -1000));
			sphere.set_nShininess(20);
			sphere.set_emmission(new Color(0, 255, 0));
			sphere.setKt(0);
			scene.addGeometry(sphere);
			
			
			Sphere sphere1 = new Sphere(150, new Point3D(-600, -500, -1000));
			sphere1.set_nShininess(20);
			sphere1.set_emmission(new Color(0, 0, 100));
			sphere1.setKt(1);
			scene.addGeometry(sphere1);
			
			
			Sphere sphere2 = new Sphere(150, new Point3D(0, -500, -1000));
			sphere2.set_nShininess(20);
			sphere2.set_emmission(new Color(255, 0, 0));
			sphere.setKt(0.5);
			scene.addGeometry(sphere2);
			
			Triangle tri1 = new Triangle(new Point3D(0, -300, -850),
					new Point3D(300, -350, -800),
					new Point3D(200, -250, -800));
			
			tri1.set_nShininess(20);
			tri1.set_emmission(new Color(255, 255, 0));
			scene.addGeometry(tri1);
			Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
					 						 new Point3D( -1500,  1500, -1500),
					 						 new Point3D(  200,  200, -375));
			
			Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
											  new Point3D( -1500,  1500, -1500),
											  new Point3D( -1500, -1500, -1500));
			
			triangle.set_emmission(new Color(20, 20, 20));
			triangle2.set_emmission(new Color(20, 20, 20));
			triangle.setKr(1);
			triangle2.setKr(0.5);
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);

			scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
					   new Vector(-2, -2, -3), 0, 0.00001, 0.000005));
		
			ImageWriter imageWriter = new ImageWriter("RR and Shadow Test2", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter, scene);
			
			render.renderImage();
			render.writeToImage();
			
		}
		
		@Test

		public void spotLightTest1(){


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

			

			ImageWriter imageWriter = new ImageWriter("Spot Shadow test 1", 500, 500, 500, 500);


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


			Triangle triangle = new Triangle(new Point3D(-125, -225, -350),

					new Point3D(-225, -125, -350),

					new Point3D(-225, -225, -360));


			triangle.set_emmission(new Color (0, 0, 100));

			triangle.set_nShininess(4);

			scene.addGeometry(triangle);


			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

					new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

			

			ImageWriter imageWriter = new ImageWriter("Spot Shadow test 2", 500, 500, 500, 500);


			Render render = new Render(imageWriter, scene);


			render.renderImage();

			render.writeToImage();


		}
		
		
		
		 
			@Test

			public void pointLightTest1(){


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


				scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

						 0.1, 0.00001, 0.000005));

				

				ImageWriter imageWriter = new ImageWriter("Point Shadow test 1", 500, 500, 500, 500);


				Render render = new Render(imageWriter, scene);


				render.renderImage();

				render.writeToImage();


			}
			
			
			
			 @Test
			 public void spotLightTest3(){
			  
			  Scene scene = new Scene();
			  scene.setScreenDistance(200);
			  Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
			  sphere.set_nShininess(20);
			  sphere.set_emmission(new Color(0, 0, 100));
			  scene.addGeometry(sphere);
			  
			  Triangle triangle = new Triangle(new Point3D(-125, -225, -520),
			           new Point3D(-225, -125, -520),
			           new Point3D(-225, -225, -540));
			  
			  triangle.set_emmission(new Color (0, 0, 100));
			  triangle.set_nShininess(4);
			  scene.addGeometry(triangle);
			  
			  scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -300), 
			        new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));
			 
			  ImageWriter imageWriter = new ImageWriter("Spot Shadow test 3", 500, 500, 500, 500);
			  
			  Render render = new Render(imageWriter, scene);
			  
			  render.renderImage();
			  render.writeToImage();
			  
			 }
			 
				@Test

				public void pointLightTest4(){


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


					scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-250, -250, -150),

							 0.1, 0.00001, 0.000005));

					

					ImageWriter imageWriter = new ImageWriter("Point Shadow test 1 point far", 500, 500, 500, 500);


					Render render = new Render(imageWriter, scene);


					render.renderImage();

					render.writeToImage();


				}
			
			
			
			@Test

			public void pointLightTest2(){


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


				scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),

						 0.1, 0.00001, 0.000005));

				

				ImageWriter imageWriter = new ImageWriter("Point Shadow test 2", 500, 500, 500, 500);


				Render render = new Render(imageWriter, scene);


				render.renderImage();

				render.writeToImage();


			}
			
			
			
			 @Test
			 public void pointLightTest3(){
			  
			  Scene scene = new Scene();
			  scene.setScreenDistance(200);
			  Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
			  sphere.set_nShininess(20);
			  sphere.set_emmission(new Color(0, 0, 100));
			  scene.addGeometry(sphere);
			  
			  Triangle triangle = new Triangle(new Point3D(-125, -225, -520),
			           new Point3D(-225, -125, -520),
			           new Point3D(-225, -225, -540));
			  
			  triangle.set_emmission(new Color (0, 0, 100));
			  triangle.set_nShininess(4);
			  scene.addGeometry(triangle);
			  
				scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 0.1, 0.00001, 0.000005));
			 
			  ImageWriter imageWriter = new ImageWriter("Point Shadow test 3", 500, 500, 500, 500);
			  
			  Render render = new Render(imageWriter, scene);
			  
			  render.renderImage();
			  render.writeToImage();
			  
			 }
}