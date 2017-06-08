package unitTest;

import geometries.*;
import primitives.*;

import renderer.*;
import scene.*;
import elements.*;
import java.awt.Color;

import org.junit.Test;

public class RenderTest 
{
	 
    @Test
    public void basicRendering(){
         
    	Scene scene = new Scene(new AmbientLight(255,255,255), 
				    			new Color(0,0,0), 
				    			new Camera(), 40);
         
        scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));
         
        Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
                                         new Point3D(  0, 100, -49),
                                         new Point3D( 100, 100, -49));
         
        Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
                                          new Point3D(  0, -100, -49),
                                          new Point3D( 100,-100, -49));
         
        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
                                          new Point3D(  0, 100, -49),
                                          new Point3D(-100, 100, -49));
         
        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
                                          new Point3D(  0,  -100, -49),
                                          new Point3D(-100, -100, -49));
         
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
         
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
         
        Render render = new Render(imageWriter, scene);
         
        render.renderImage();
     //   render.printGrid(50);
        render.writeToImage();
         
    }
     
}
