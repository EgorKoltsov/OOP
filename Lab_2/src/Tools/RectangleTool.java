package Tools;

import Figures.Rectangle;
import GUI.DrawingPanel;

import java.awt.event.MouseEvent;

// A class that implements a tool for drawing a rectangle
public class RectangleTool extends DrawingTool {
    // Class constructor
    public RectangleTool(DrawingPanel drawingPanel) {
        super(drawingPanel);
        toolType = FigureType.Rectangle;
    }

    // Getting this button tool method
    @Override
    public DrawingTool getTool()
    {
        return new RectangleTool(drawingPanel);
    }

    // Pressing mouse button handler method
    @Override
    public void ProcessMousePressed(int x, int y, int mouseButton)
    {
        // If the left mouse button is pressing
        if (mouseButton == MouseEvent.BUTTON1) {
            // If we haven't drawn a shape yet, create a rectangle with a height and width of 1
            drawingFigure = new Rectangle(x, y, 1, 1);
            drawingPanel.drawingFigure = drawingFigure;
        }
    }

    // Dragging mouse button handler method
    @Override
    public void ProcessMouseDragged(int x, int y, int mouseButton)
    {
        if (drawingFigure == null)
            return;

        // Coordinates of the upper-left corner of the rectangle
        double xPos = drawingFigure.position.getX();
        double yPos = drawingFigure.position.getY();

        // Updating rectangle width and height
        ((Rectangle) drawingFigure).height = y > yPos ? (int) (y - yPos) : 1;
        ((Rectangle) drawingFigure).width = x > xPos ? (int) (x - xPos) : 1;

        drawingFigure.updateAppearance();
    }

    // Releasing mouse button handler method
    @Override
    public void ProcessMouseReleased(int x, int y, int mouseButton)
    {
        if (mouseButton == MouseEvent.BUTTON1) {
            drawingPanel.figureDrawingIsEnded();;
            drawingFigure = null;
        }
    }
}
