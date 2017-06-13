/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import geometries.Triangle;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import main.panel.CameraPanel;
import main.panel.TrianglePanel;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

/**
 *
 * @author mailo
 */
public class TriangleFram {

    static JFrameWin jFrameWindow;

    public static class MyComponent extends JComponent {
    
        BufferedImage bufferedImage;
        Dimension myDimension;
        private Triangle triangle;
        Scene scene = new Scene();

        public MyComponent(Triangle triangle) {

            this.triangle = triangle;
            setTriangle(triangle);
        }

        @Override
        public Dimension getPreferredSize() {
            return myDimension;
        }

        @Override
        public Dimension getMaximumSize() {
            return myDimension;
        }

        @Override
        public Dimension getMinimumSize() {
            return myDimension;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Render render = new Render();
            try {

                if (triangle != null) {
                    ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

                    render = new Render(imageWriter, scene);

                    bufferedImage = render.renderImage().getImage();
                    myDimension = new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "render:\n" + e.getMessage());//, JOptionPane.ERROR_MESSAGE);
            } finally {
                bufferedImage = render.printGrid(50).getImage();
            }
            g.drawImage(bufferedImage, 0, 0, null);
        }

        /**
         * @return the sphere
         */
        public Triangle getTriangle() {
            return triangle;
        }

        /**
         * @param sphere the sphere to set
         */
        public void setTriangle(Triangle triangle) {
            this.triangle = triangle;

            scene.clearAllGeometry();
            scene.addGeometry(triangle);
        }
    }

    public static class JFrameWin extends JFrame {

        MyComponent myComponent = new MyComponent(null);

        public JFrameWin() {
            this.setTitle("test Render ...");
            this.setSize(550, 850);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            TrianglePanel trianglePanel = new TrianglePanel();
            CameraPanel cameraPanel = new CameraPanel();

            cameraPanel.setCamera(myComponent.scene.getCamera());

            JPanel hPanel = new JPanel();
            BoxLayout boxLayout = new BoxLayout(hPanel, BoxLayout.Y_AXIS);
            hPanel.setLayout(boxLayout);

            JButton runButton = new JButton("run ");

            runButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {

                        myComponent.setTriangle(trianglePanel.getTriangle());
                        myComponent.scene.setCamera(cameraPanel.getCamera());
                        revalidate();
                        repaint();
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(JFrameWin.this, e2.getMessage());//, JOptionPane.ERROR_MESSAGE);
                    }

                }
            });

            hPanel.add(new Label("Triangle: "));
            hPanel.add(trianglePanel);
            
             hPanel.add(new Label("Camera: "));
            hPanel.add(cameraPanel);
            hPanel.add(runButton);
           
            this.add(hPanel, BorderLayout.NORTH);           
            this.add(myComponent);
        }
    }

    public static void main(String[] args) {
        System.out.println("start ...");

        Runnable doSwingLater = new Runnable() {
            public void run() {
                jFrameWindow = new JFrameWin();
                jFrameWindow.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(doSwingLater);
    }
}
