package Figures;

import Tools.FigureType;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

// An abstract class representing a shape
abstract public class Figure implements Serializable {
    boolean[][] appearance;
    public Point2D position = new Point();

    // Class constructor. The x and y parameters are the coordinates of the shape on the canvas
    Figure(int x, int y)
    {
        position.setLocation(x, y);
    }

    // The method of drawing an instance onto the canvas
    public void paint(Graphics g)
    {
        Color oldC = g.getColor();
        g.setColor(Color.black);

        for (int i = 0; i < appearance.length; i++)
        {
            for (int j = 0; j < appearance[0].length; j++)
            {
                if (appearance[i][j])
                    // Рисуем точку
                    g.drawLine((int) (position.getX() + j), (int) (position.getY() + i), (int) (position.getX() + j), (int) (position.getY() + i));
            }
        }
        g.setColor(oldC);
    }

    // Method for getting the shape type
    public abstract FigureType getFigureType();

    // Method for updating the shape image array
    public abstract void updateAppearance();
}
