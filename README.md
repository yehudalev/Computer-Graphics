# Computer Graphics
### program which renders Computer Graphics

A graphical scene needs:

1. 3D model
2. Camera 
3. View-plan
4. light

We split it to packages which include classes for each responsibility filed.
We implemented it in Java from the starch. 

A package `Elements` includes classes for a camera and a variety of lights for use in the model.

A package `Geometries` for geometries in the 3D Model such as Plane Sphere, Triangle.

A package `Primitives` Which we implement the Coordinate, Point2D, Point3D, Ray, Vector

A package `Renderer` which handles the rendering into a scene

For each responsibly filed we created a test with unitTest

some rendering results:
![alt text](https://github.com/DoviSussmann/mini-project-JAVA/blob/master/%D7%9C%D7%A4%D7%A0%D7%99%20%D7%90%D7%97%D7%A8%D7%99/RR%20and%20Shadow%20Test2.jpg)
