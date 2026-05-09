package Figures;

import Tools.FigureType;

// A class that implements the shape of a triangle
public class Triangle extends Figure {
    public int height;
    public int width;
    public int offset;

    /*
        The constructor of the class. The x and y parameters are the coordinates of the shape on the canvas.
        The height, width, and offset parameters are the height, width, and offset of the triangle's vertex relative to the center of the base, respectively
     */
    public Triangle(int x, int y, int height, int width, int offset)
    {
        super(x, y);

        this.height = height;
        this.width = width;
        this.offset = offset;

        updateAppearance();
    }

    // Method for updating the triangle image array based on the current values of its parameters
    @Override
    public void updateAppearance()
    {
        appearance = new boolean[height][width];
        double baseRightAngle = Math.atan((double) height / ((double) width / 2 - offset));
        double baseLeftAngle = Math.atan((double) height / ((double) width / 2 + offset));

        for (int j = 0; j < height; j++)
        {
            for (int i = 0; i < width; i++)
            {
                double leftAngle = Math.atan((double) (height - j) / i);
                double rightAngle = Math.atan((double) (height - j) / (width - i));
                if (Math.abs(rightAngle) <= baseRightAngle && Math.abs(leftAngle) <= baseLeftAngle)
                    appearance[j][i] = true;
            }
        }
    }

    // Method for getting the shape type
    @Override
    public FigureType getFigureType()
    {
        return FigureType.Triangle;
    }

    // Method for creating a copy of an instance
    public static Figure getCopy(Figure fig)
    {
        Triangle triangleFig = (Triangle) fig;
        return new Triangle((int) triangleFig.position.getX(), (int) triangleFig.position.getY(), triangleFig.height, triangleFig.width, triangleFig.offset);
    }
}