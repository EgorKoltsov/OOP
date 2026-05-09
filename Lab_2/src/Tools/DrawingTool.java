package Tools;

import Figures.Figure;
import GUI.DrawingPanel;

// Abstract class for drawing something on a canvas (adding a shape to a list)
// Idea: To represent a drawing device as an object with a number of states,
// On which actions are performed and between which the transition is made when calling the Process<Action> methods
public abstract class DrawingTool {
    DrawingPanel drawingPanel;
    Figure drawingFigure;
    public FigureType toolType;

    // Class constructor
    DrawingTool(DrawingPanel drawingPanel)
    {
        this.drawingPanel = drawingPanel;
    }

    // Pressing mouse button handler method
    public void ProcessMousePressed(int x, int y, int mouseButton)
    {

    }

    // Dragging mouse button handler method
    public void ProcessMouseDragged(int x, int y, int mouseButton)
    {

    }

    // Releasing mouse button handler method
    public void ProcessMouseReleased(int x, int y, int mouseButton)
    {

    }

    // Getting this button tool method
    public abstract DrawingTool getTool();
}

