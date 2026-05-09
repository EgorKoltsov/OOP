package Figures;

import Tools.FigureType;

// A class that implements the shape of a circle
public class Circle extends Ellipse {

    // Class constructor. The x and y parameters are the coordinates of the shape on the canvas. The radius parameter is the radius of the shape
    public Circle(int x, int y, int radius)
    {
        super(x, y, radius, radius);
    }

    // Method for getting the shape type
    @Override
    public FigureType getFigureType()
    {
        return FigureType.Circle;
    }

    // Method for creating a copy of an instance
    public static Figure getCopy(Figure fig)
    {
        Circle circleFig = (Circle) fig;
        return new Circle((int) circleFig.position.getX(), (int) circleFig.position.getY(), circleFig.a);
    }
}
