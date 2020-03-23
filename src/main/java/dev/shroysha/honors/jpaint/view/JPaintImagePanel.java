package dev.shroysha.honors.jpaint.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class JPaintImagePanel extends JPanel {

    private Graphics g;
    private Color brushColor;

    public JPaintImagePanel() {
        init();
    }

    private void init() {
        g = this.getGraphics();

        this.addMouseListener(new MyMouseListener());
        this.setPreferredSize(new Dimension(400, 600));
        this.setForeground(Color.red);
    }

    public void paintComponent(Graphics g) {
    }

    public void setImage() {
    }

    public void setBrushColor(Color colorTemp) {
        g.setColor(colorTemp);
    }


    private class MyMouseListener implements MouseMotionListener, MouseListener {

        private boolean mousePressed;

        public MyMouseListener() {
            mousePressed = false;
        }

        public void mouseClicked(MouseEvent e) {
            drawOnPoint(e);
        }

        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
        }


        public void mouseEntered(MouseEvent e) {
        }


        public void mouseExited(MouseEvent e) {
        }


        public void mouseDragged(MouseEvent e) {
            drawOnPoint(e);
        }


        public void mouseMoved(MouseEvent e) {
            if (mousePressed) {
                drawOnPoint(e);
            }
        }

        private void drawOnPoint(MouseEvent e) {
            int mouseX = e.getPoint().x;
            int mouseY = e.getPoint().y;

            int brushThickness = 5;
            g.fillOval(mouseX - brushThickness, mouseY - brushThickness, mouseX + brushThickness, mouseY + brushThickness);
        }

    }
}
