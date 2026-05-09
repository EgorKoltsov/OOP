// A class that implements the shape of a rectangle
public class Rectangle extends Figure {
    /*
        The constructor of the class. The x and y parameters are the coordinates of the shape on the canvas.
        The width and height parameters are the width and height of the rectangle, respectively.
    */
    Rectangle (int height, int width)
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
}
