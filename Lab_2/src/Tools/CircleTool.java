package Tools;

import Figures.Circle;
import GUI.DrawingPanel;

import java.awt.event.MouseEvent;

// A class that implements a tool for drawing a circle
public class CircleTool extends DrawingTool {
    // Class constructor
    public CircleTool(DrawingPanel drawingPanel) {
        super(drawingPanel);
        toolType = FigureType.Circle;
    }

    // Pressing mouse button handler method
    @Override
    public void ProcessMousePressed(int x, int y, int mouseButton)
    {
        // If left mouse button is pressed
        if (mouseButton == MouseEvent.BUTTON1) {
            // If we haven't drawn a shape yet, create a circle with a radius of 1 and add it to the drawing list
            drawingFigure = new Circle(x, y, 1);
            drawingPanel.drawingFigure = drawingFigure;
        }
    }

    // Dragging mouse button handler method
    @Override
    public void ProcessMouseDragged(int x, int y, int mouseButton)
    {
        if (drawingFigure == null)
            return;

        // Circle x and y coordinates
        double xPos = drawingFigure.position.getX() + ((Circle) drawingFigure).a;
        double yPos = drawingFigure.position.getY() + ((Circle) drawingFigure).a;

        // Based on mouse coordinates updating circle radius
        int newRadius = (int) Math.sqrt((int) Math.pow(Math.abs(x - xPos), 2) + (int) Math.pow(Math.abs(y - yPos), 2));
        int oldRadius = ((Circle) drawingFigure).a;
        ((Circle) drawingFigure).a = ((Circle) drawingFigure).b = newRadius;

        if (newRadius - oldRadius > 0)
            drawingFigure.position.setLocation(drawingFigure.position.getX() - (newRadius - oldRadius), drawingFigure.position.getY() - (newRadius - oldRadius));
        else
            drawingFigure.position.setLocation(drawingFigure.position.getX() + (oldRadius - newRadius), drawingFigure.position.getY() + (oldRadius - newRadius));

        drawingFigure.updateAppearance();
    }

    // Releasing mouse button handler method
    @Override
    public void ProcessMouseReleased(int x, int y, int mouseButton)
    {
        if (mouseButton == MouseEvent.BUTTON1) {
            drawingFigure = null;
            drawingPanel.figureDrawingIsEnded();
        }
    }

    // Getting this button tool method
    @Override
    public DrawingTool getTool()
    {
        return new CircleTool(drawingPanel);
    }

}