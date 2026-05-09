package GUI;

import Figures.*;
import Figures.Rectangle;
import Tools.DrawingTool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

// A class that implements a button for changing the drawing tool
public class ToolButton extends JPanel implements ActionListener, MouseListener {
    // Tool that is given when button is clicked
    DrawingTool tool;
    DrawingPanel drawingPanel;
    List<ToolButton> toolButtons;

    // Class constructor, tool, drawingPanel, and toolButtons parameters - the drawing tool, drawing panel, and other tool buttons
    ToolButton(DrawingTool tool, DrawingPanel drawingPanel, List<ToolButton> toolButtons)
    {
        super();
        this.toolButtons = toolButtons;
        toolButtons.add(this);

        this.tool = tool;
        this.drawingPanel = drawingPanel;

        // adding mouse listener
        addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // The method of clicking on the button
    @Override
    public void mouseClicked(MouseEvent e) {
        drawingPanel.activeTool = tool.getTool();

        // Updating tool buttons appearance (to highlight current tool button and to remove highlight from the previous tool button)
        for (ToolButton toolButton : toolButtons)
            toolButton.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Painting the button method
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // If this button is an active button highlighting it
        if (tool.getClass() == drawingPanel.activeTool.getClass()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(10));

            g2.setColor(Color.ORANGE);
            g2.drawRect(5, 5, 90, 90);

            g2.setStroke(new BasicStroke(1));
        }

        g.setColor(Color.BLACK);

        // Based on the button tool type and its activeness drawing the corresponding shape on it
        switch (tool.toolType)
        {
            case Circle:
                Circle circle;
                if (tool.getClass() == drawingPanel.activeTool.getClass())
                    circle = new Circle(10, 10, 40);
                else
                    circle = new Circle(15, 15, 35);
                circle.paint(g);
                break;
            case Ellipse:
                Ellipse ellipse;
                if (tool.getClass() == drawingPanel.activeTool.getClass())
                    ellipse = new Ellipse(10, 20, 40, 30);
                else
                    ellipse = new Ellipse(20, 30, 30, 20);
                ellipse.paint(g);
                break;
            case Rectangle:
                Rectangle rectangle;
                if (tool.getClass() == drawingPanel.activeTool.getClass())
                    rectangle = new Rectangle(10, 20, 60, 80);
                else
                    rectangle = new Rectangle(20, 30, 40, 60);
                rectangle.paint(g);
                break;
            case Square:
                Square square;
                if (tool.getClass() == drawingPanel.activeTool.getClass())
                    square = new Square(10, 10, 80);
                else
                    square = new Square(20, 20, 60);
                square.paint(g);
                break;
            case Triangle:
                Triangle triangle;
                if (tool.getClass() == drawingPanel.activeTool.getClass())
                    triangle = new Triangle(10, 10, 80, 80, -40);
                else
                    triangle = new Triangle(20, 20, 60, 60, -30);

                triangle.paint(g);
                break;
        }
    }
}