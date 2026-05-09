package Tools;

import Figures.Ellipse;
import GUI.DrawingPanel;

import java.awt.event.MouseEvent;

// A class that implements a tool for drawing an ellipse
public class EllipseTool extends DrawingTool {
    // Class constructor
    public EllipseTool(DrawingPanel drawingPanel) {
        super(drawingPanel);
        toolType = FigureType.Ellipse;
    }

    // Getting this button tool method
    @Override
    public DrawingTool getTool()
    {
        return new EllipseTool(drawingPanel);
    }

    // Pressing mouse button handler method
    @Override
    public void ProcessMousePressed(int x, int y, int mouseButton)
    {
        // If the left mouse button is pressing
        if (mouseButton == MouseEvent.BUTTON1) {
            // If we haven't drawn a shape yet, create a circle with a radius of 1 and add it to the drawing list
            drawingFigure = new Ellipse(x, y, 1, 1);
            drawingPanel.drawingFigure = drawingFigure;
        }
    }

    // Dragging mouse button handler method
    @Override
    public void ProcessMouseDragged(int x, int y, int mouseButton)
    {
        if (drawingFigure == null)
            return;

        // Ellipse center coordinates
        double xPos = drawingFigure.position.getX() + ((Ellipse) drawingFigure).a;
        double yPos = drawingFigure.position.getY() + ((Ellipse) drawingFigure).b;

        // Updating ellipse major and minor axes
        int newA = (int) Math.abs(x - xPos);
        int oldA = ((Ellipse) drawingFigure).a;

        int newB = (int) Math.abs(y - yPos);
        int oldB = ((Ellipse) drawingFigure).b;

        ((Ellipse) drawingFigure).a = newA;
        ((Ellipse) drawingFigure).b = newB;

        // Updating ellipse x and y position
        xPos = drawingFigure.position.getX();
        yPos = drawingFigure.position.getY();
        drawingFigure.position.setLocation(newA > oldA ? xPos - (newA - oldA) : xPos + (oldA - newA), newB > oldB ? yPos - (newB - oldB) : yPos + (oldB - newB));

        drawingFigure.updateAppearance();
    }

    // Releasing mouse button handler method
    @Override
    public void ProcessMouseReleased(int x, int y, int mouseButton)
    {
        if (mouseButton == MouseEvent.BUTTON1) {
            drawingPanel.figureDrawingIsEnded();
            drawingFigure = null;
        }
    }
}
