package Tools;

import Figures.Square;
import GUI.DrawingPanel;

import java.awt.event.MouseEvent;

// A class that implements a tool for drawing a square
public class SquareTool extends DrawingTool {
    // Class constructor
    public SquareTool(DrawingPanel drawingPanel) {
        super(drawingPanel);
        toolType = FigureType.Square;
    }

    // Pressing mouse button handler method
    @Override
    public void ProcessMousePressed(int x, int y, int mouseButton)
    {
        // If the left mouse button is pressing
        if (mouseButton == MouseEvent.BUTTON1) {
            // If we haven't drawn a shape yet, create a square with a side length of 1
            drawingFigure = new Square(x, y, 1);
            drawingPanel.drawingFigure = drawingFigure;
        }
    }

    // Dragging mouse button handler method
    @Override
    public void ProcessMouseDragged(int x, int y, int mouseButton)
    {
        if (drawingFigure == null)
            return;

        // Coordinates of the upper-left corner of the square
        double xPos = drawingFigure.position.getX();
        double yPos = drawingFigure.position.getY();

        // Updating square side length
        int newSideLen = (int) Math.max(x > xPos ? x - xPos : 1, y > yPos ? y - yPos : 1);
        ((Square) drawingFigure).width = ((Square) drawingFigure).height = newSideLen;

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

    // Getting this button tool method
    @Override
    public DrawingTool getTool()
    {
        return new SquareTool(drawingPanel);
    }
}
