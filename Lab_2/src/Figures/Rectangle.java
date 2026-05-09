package Figures;

import Tools.FigureType;

// A class that implements the shape of a rectangle
public class Rectangle extends Figure {
    public int height;
    public int width;

    /*
        The constructor of the class. The x and y parameters are the coordinates of the shape on the canvas.
        The width and height parameters are the width and height of the rectangle, respectively.
     */
    public Rectangle(int x, int y, int height, int width)
    {
        super(x, y);

        this.height = height;
        this.width = width;

        updateAppearance();
    }

    // Method for updating the rectangle image array based on the current values of its parameters
    @Override
    public void updateAppearance()
    {
        appearance = new boolean[height][width];

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                appearance[i][j] = true;
            }
        }
    }

    // Method for getting the shape type
    @Override
    public FigureType getFigureType()
    {
        return FigureType.Rectangle;
    }

    // Method for creating a copy of an instance
    public static Figure getCopy(Figure fig)
    {
        Rectangle rectangleFig = (Rectangle) fig;
        return new Rectangle((int) rectangleFig.position.getX(), (int) rectangleFig.position.getY(), rectangleFig.height, rectangleFig.width);
    }
}