package Figures;

import Tools.FigureType;

// A class that implements the shape of an ellipse
public class Ellipse extends Figure {
    public int a;
    public int b;

    /*
        Class constructor. The x and y parameters are the coordinates of the shape on the canvas.
        The a and b parameters are the major and minor axes of the ellipse, respectively
     */
    public Ellipse(int x, int y, int a, int b)
    {
        super(x, y);

        this.a = a;
        this.b = b;

        updateAppearance();
    }

    // Method for updating the ellipse image array based on the current values of its parameters
    @Override
    public void updateAppearance()
    {
        appearance = new boolean[b * 2][a * 2];

        for (int j = 0; j < appearance.length; j++)
        {
            for (int i = 0; i < appearance[0].length; i++)
            {
                if (Math.pow(i - a, 2) / (a * a) + Math.pow(j - b, 2) / (b * b) <= 1)
                    appearance[j][i] = true;
            }
        }
    }

    // Method for getting the shape type
    @Override
    public FigureType getFigureType()
    {
        return FigureType.Ellipse;
    }

    // Method for creating a copy of an instance
    public static Figure getCopy(Figure fig)
    {
        Ellipse ellipseFig = (Ellipse) fig;
        return new Ellipse((int) ellipseFig.position.getX(), (int) ellipseFig.position.getY(), ellipseFig.a, ellipseFig.b);
    }
}
