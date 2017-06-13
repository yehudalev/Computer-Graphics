/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.panel;

import java.text.NumberFormat;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import primitives.Point3D;

/**
 *
 * @author mailo
 */
public class Point3Dpanel extends JPanel {
    // private Point3D point3D;

    JFormattedTextField pointXtext;
    JFormattedTextField pointYtext;
    JFormattedTextField pointZtext;

    public Point3Dpanel() {
        // JPanel hPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(boxLayout);

        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        //  formatter.setMinimum(0);
        // formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);

        pointXtext = new JFormattedTextField(formatter);
        pointXtext.setToolTipText("point X text");
        new GhostText(pointXtext, "point X text ");
        this.add(pointXtext);

        pointYtext = new JFormattedTextField(formatter);
        pointYtext.setToolTipText("point Y text");
        new GhostText(pointYtext, "point Y text ");
        this.add(pointYtext);

        pointZtext = new JFormattedTextField(formatter);
        pointZtext.setToolTipText("point Z text");
        new GhostText(pointZtext, "point Z text ");
        this.add(pointZtext);

    }

    /**
     * @return the point3D
     */
    public Point3D getPoint3D() {

        double x = Double.parseDouble(pointXtext.getText());
        double y = Double.parseDouble(pointYtext.getText());
        double z = Double.parseDouble(pointZtext.getText());

        return new Point3D(x, y, z);
    }

    /**
     * @param point3D the point3D to set
     */
    public void setPoint3D(Point3D point3D) {
        this.pointXtext.setText(String.valueOf(point3D.getX().getCoordinate()));
        this.pointYtext.setText(String.valueOf(point3D.getY().getCoordinate()));
        this.pointZtext.setText(String.valueOf(point3D.getZ().getCoordinate()));
        
         revalidate();
                        repaint();
    }

}
