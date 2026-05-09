package GUI;

import Figures.Figure;
import Tools.DrawingTool;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// A class representing a panel for drawing shapes on it
public class DrawingPanel extends JPanel implements MouseListener, MouseInputListener {
    public static final int width = 1470;
    public static final int height = 1000;

    // Shapes already drawn on the panel (to save them to a file)
    java.util.List<Figure> drawnFigures = new ArrayList<>();
    public DrawingTool activeTool;

    // Not yet added, but already drawn shape (null if nothing is drawn)
    public Figure drawingFigure;
    Image drawedFiguresImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // Panel constructor
    DrawingPanel()
    {
        // I don't know what's happening in the JPanel constructor, so let's call
        super();

        setBounds(0, 30, width, height);

        // Add mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);

        // Filling the drawing area with white color
        Graphics g = drawedFiguresImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
    }

    // Rendering the panel
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(drawedFiguresImage, 0, 0, null);
        if (drawingFigure != null)
            drawingFigure.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // Redirecting the mouse pressing to the drawing tool
    @Override
    public void mousePressed(MouseEvent e) {
        if (activeTool != null) {
            activeTool.ProcessMousePressed(e.getX(), e.getY(), e.getButton());
            repaint();
        }
    }

    // Redirecting the mouse releasing to the drawing tool
    @Override
    public void mouseReleased(MouseEvent e) {
        if (activeTool != null) {
            activeTool.ProcessMouseReleased(e.getX(), e.getY(), e.getButton());
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Redirecting the mouse dragging to the drawing tools
    @Override
    public void mouseDragged(MouseEvent e) {
        if (activeTool != null)
        {
            activeTool.ProcessMouseDragged(e.getX(), e.getY(), e.getButton());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    // A method called by the drawing tool when it draws a shape
    public void figureDrawingIsEnded() {
        Graphics g = drawedFiguresImage.getGraphics();
        drawingFigure.paint(g);
        drawnFigures.add(drawingFigure);
        drawingFigure = null;
    }
}
