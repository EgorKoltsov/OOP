package Tools;

import Figures.Triangle;
import GUI.DrawingPanel;

import java.awt.event.MouseEvent;

public class TriangleTool extends DrawingTool {
    boolean drawingSize;
    boolean drawingOffset;

    // A class that implements a tool for drawing a triangle
    public TriangleTool(DrawingPanel drawingPanel) {
        super(drawingPanel);
        toolType = FigureType.Triangle;
    }

    // Getting this button tool method
    @Override
    public DrawingTool getTool()
    {
        return new TriangleTool(drawingPanel);
    }

    // Pressing mouse button handler method
    @Override
    public void ProcessMousePressed(int x, int y, int mouseButton)
    {
        // If the left mouse button is pressing
        if (mouseButton == MouseEvent.BUTTON1) {
            if (!drawingSize && !drawingOffset)
            {
                // If we haven't drawn a shape yet, create an isosceles triangle with a height and width of 10 pixels
                drawingFigure = new Triangle(x, y, 10, 10, 0);
                drawingPanel.drawingFigure = drawingFigure;

                drawingSize = true;
            }
        }
    }

    // Dragging mouse button handler method
    @Override
    public void ProcessMouseDragged(int x, int y, int mouseButton)
    {
        if (drawingFigure == null)
            return;

        // Updating x and y triangle coordinates
        int xPos = (int) drawingFigure.position.getX();
        int yPos = (int) drawingFigure.position.getY();

        if (drawingSize)
        {
            // If drawing size and height updating only width and height
            if (y < yPos)
                ((Triangle) drawingFigure).height = 1;
            else {
                ((Triangle) drawingFigure).height = y - yPos;
            }

            if (x < xPos)
                ((Triangle) drawingFigure).width = 1;
            else
                ((Triangle) drawingFigure).width = x - xPos;
        }
        else if (drawingOffset)
        {
            // If drawing offset updating offset value
            if (x < xPos)
                ((Triangle) drawingFigure).offset = -((Triangle) drawingFigure).width / 2;
            else if (x < xPos + ((Triangle) drawingFigure).width)
                ((Triangle) drawingFigure).offset = -(xPos + ((Triangle) drawingFigure).width / 2 - x);
            else
                ((Triangle) drawingFigure).offset = ((Triangle) drawingFigure).width / 2;
        }

        drawingFigure.updateAppearance();
    }

    // Releasing mouse button handler method
    @Override
    public void ProcessMouseReleased(int x, int y, int mouseButton)
    {
        // Changing the drawing stage phases
        if (mouseButton == MouseEvent.BUTTON1 && !drawingSize && !drawingOffset) {
            drawingFigure = null;
        }
        else if (drawingSize)
        {
            drawingSize = false;
            drawingOffset = true;
        }
        else {
            drawingOffset = false;
            drawingPanel.figureDrawingIsEnded();
            drawingFigure = null;
        }
    }
}
