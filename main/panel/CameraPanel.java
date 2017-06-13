/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panel;

import elements.Camera;
import java.awt.GridLayout;
//import java.awt.GridLayout;
//import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import primitives.Vector;

/**
 *
 * @author mailo
 */
public class CameraPanel extends JPanel{
    
    Point3Dpanel p0;
    Point3Dpanel vUp;
    Point3Dpanel vTo;
    
   
 
    public CameraPanel() {
      
      
      p0 = new Point3Dpanel();
      vUp = new Point3Dpanel();
      vTo = new Point3Dpanel();
      
      // BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
       // this.setLayout(boxLayout);
//      
      

     GridLayout grid = new GridLayout(0,2);
       this.setLayout(grid);
       
       this.add(new JLabel("P0: "));
       this.add(p0);
       
       this.add(new JLabel("Vup: "));
       this.add(vUp);
       
       this.add(new JLabel("Vto: "));
       this.add(vTo);
       
          
    }
    
     public Camera getCamera() {

        return new Camera(p0.getPoint3D(), new Vector(vUp.getPoint3D()) , new Vector(vTo.getPoint3D()));
    }

    /**
     * @param point3D the point3D to set
     */
    public void setCamera(Camera camera) {
      this.p0.setPoint3D(camera.getP0());
      this.vUp.setPoint3D(camera.get_vUp().getHead());
      this.vTo.setPoint3D(camera.get_vTo().getHead());    
    }
}
