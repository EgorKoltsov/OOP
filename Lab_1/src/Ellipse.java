// A class that implements the shape of an ellipse
public class Ellipse extends Figure {
    /*
        Class constructor. The x and y parameters are the coordinates of the shape on the canvas.
        The a and b parameters are the major and minor axes of the ellipse, respectively
    */
    Ellipse (int a, int b)
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
}
