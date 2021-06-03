package app.paint.layout;

import app.paint.shape.Elipse;
import app.paint.shape.PaintShape;
import app.paint.shape.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel {
    private List<PaintShape> paintShapes = new ArrayList<>();

    public PaintPanel() {
        addMouseListener(new DrawListener());
        addMouseMotionListener(new DrawListener());
        setBackground(Color.WHITE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D

        Graphics2D graphics2D = (Graphics2D) g;
        for (PaintShape paintShape : paintShapes) {
            graphics2D.setColor(paintShape.getColor());
            graphics2D.fill(paintShape.createShape());
        }
    }

    public List<PaintShape> getPaintShapes() {
        return paintShapes;
    }

    private class DrawListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mouseMovement(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseMovement(e);
        }

        private void mouseMovement(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            PaintWindow window = PaintWindow.getInstance();
            Color color = window.getSelectedColor();
            PaintShape paintShape = window.isCircleSelected() ?
                    new Elipse(e.getX(), e.getY(), color) :
                    new Rectangle(e.getX(), e.getY(), color);
            paintShapes.add(paintShape);
            repaint();
        }
    }

}
