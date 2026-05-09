package Figures;

import Tools.FigureType;

// A class that implements the shape of a square
public class Square extends Rectangle {
    /*
        The constructor of the class. The x and y parameters are the coordinates of the shape on the canvas.
        sideLen parameter is the Square side length
    */
    public Square(int x, int y, int sideLen)
    {
        super(x, y, sideLen, sideLen);
    }

    // Method for getting the shape type
    @Override
    public FigureType getFigureType()
    {
        return FigureType.Square;
    }

    // Method for creating a copy of an instance
    public static Figure getCopy(Figure fig)
    {
        Square squareFig = (Square) fig;
        return new Square((int) squareFig.position.getX(), (int) squareFig.position.getY(), squareFig.height);
    }
}
