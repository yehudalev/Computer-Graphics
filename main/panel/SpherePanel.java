/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panel;

import geometries.Sphere;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import primitives.Point3D;

/**
 *
 * @author mailo
 */
public class SpherePanel extends JPanel{
    
    Point3Dpanel point3Dpanel;
JTextField radiusText ;

    public SpherePanel() {
        
            BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
            this.setLayout(boxLayout);

            radiusText = new JTextField();
            GhostText ghostText = new GhostText(radiusText, "radius ");
            this.add(radiusText);
            
            point3Dpanel = new Point3Dpanel();
            this.add(point3Dpanel);
            
            
    }
            
    
    public Sphere getSphere() {

       double r = Double.parseDouble(radiusText.getText());

        return new Sphere(r, point3Dpanel.getPoint3D());
    }

    /**
     * @param point3D the point3D to set
     */
    public void setSphere(Sphere sphere) {
        this.point3Dpanel.setPoint3D( sphere.getCenter());
        this.radiusText.setText(String.valueOf(sphere.getRadius()));
    }
    
    
}
