// A class that implements the shape of a triangle
public class Triangle extends Figure {
    /*
        The constructor of the class. The x and y parameters are the coordinates of the shape on the canvas.
        The height, width, and offset parameters are the height, width, and offset of the triangle's vertex relative to the center of the base, respectively
    */
    Triangle(int height, int width, int offset)
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
}
