import java.awt.*;

// An abstract class representing a shape
abstract public class Figure {
    boolean[][] appearance;

    // The method of drawing an instance onto the canvas
    void paint(Graphics g, java.awt.Rectangle canvasRect)
    {
        Color oldC = g.getColor();
        g.setColor(Color.black);

        for (int i = 0; i < canvasRect.height; i++)
        {
            if (i < appearance.length)
            {
                for (int j = 0; j < canvasRect.width; j++)
                {
                    if (j < appearance[0].length)
                    {
                        if (appearance[i][j])
                            // Рисуем точку
                            g.drawLine(canvasRect.x + j, canvasRect.y + i, canvasRect.x + j, canvasRect.y + i);
                    }
                }
            }
        }
        g.setColor(oldC);
    }
}
