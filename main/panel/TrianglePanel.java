/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panel;

import elements.Camera;
import geometries.Triangle;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import primitives.Vector;

/**
 *
 * @author mailo
 */
public class TrianglePanel extends JPanel{
    
    Point3Dpanel p1;
    Point3Dpanel p2;
    Point3Dpanel p3;
      
 
    public TrianglePanel() {
         
      p1 = new Point3Dpanel();
      p2 = new Point3Dpanel();
      p3 = new Point3Dpanel();
      

     GridLayout grid = new GridLayout(0,2);
       this.setLayout(grid);
       
       this.add(new JLabel("P1: "));
       this.add(p1);
       
       this.add(new JLabel("p2: "));
       this.add(p2);
       
       this.add(new JLabel("p3: "));
       this.add(p3);
       
          
    }
    
     public Triangle getTriangle() {

        return new Triangle(p1.getPoint3D(), (p2.getPoint3D()) , (p3.getPoint3D()));
    }

    
    public void setTriangle( Triangle  triangle) {
      this.p1.setPoint3D(triangle.getP1());
      this.p2.setPoint3D(triangle.getP2());
      this.p3.setPoint3D(triangle.getP3());    
    }
}