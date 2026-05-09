package GUI;

import Figures.*;
import Tools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// The main form of the application
public class Form extends JFrame implements ActionListener {
    DrawingPanel drawingPanel;

    // Buttons for getting drawing tools
    java.util.List<ToolButton> toolButtons = new ArrayList<>();

    JButton figuresFileSaveButton;
    JButton figuresFileOpenButton;

    public Form()
    {
        super("Lab_2");

        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(Color.gray);
        add(drawingPanel);

        // Placing drawing tools buttons
        ToolButton circleButton = new ToolButton(new CircleTool(drawingPanel), drawingPanel, toolButtons);
        circleButton.setBounds(1520, 20, 100, 100);
        circleButton.setBackground(Color.GRAY);
        add(circleButton);

        ToolButton squareButton = new ToolButton(new SquareTool(drawingPanel), drawingPanel, toolButtons);
        squareButton.setBounds(1520, 140, 100, 100);
        squareButton.setBackground(Color.GRAY);
        add(squareButton);

        ToolButton ellipseTool = new ToolButton(new EllipseTool(drawingPanel), drawingPanel, toolButtons);
        ellipseTool.setBounds(1520, 260, 100, 100);
        ellipseTool.setBackground(Color.GRAY);
        add(ellipseTool);

        ToolButton rectangleTool = new ToolButton(new RectangleTool(drawingPanel), drawingPanel, toolButtons);
        rectangleTool.setBounds(1520, 380, 100, 100);
        rectangleTool.setBackground(Color.GRAY);
        add(rectangleTool);

        ToolButton triangleTool = new ToolButton(new TriangleTool(drawingPanel), drawingPanel, toolButtons);
        triangleTool.setBounds(1520, 500, 100, 100);
        triangleTool.setBackground(Color.GRAY);
        add(triangleTool);

        // Placing file saving and opening button
        figuresFileOpenButton = new JButton("Open");
        figuresFileOpenButton.setBounds(0, 0, 100, 30);
        figuresFileOpenButton.addActionListener(this);
        add(figuresFileOpenButton);

        figuresFileSaveButton = new JButton("Save");
        figuresFileSaveButton.setBounds(130, 0, 100, 30);
        figuresFileSaveButton.addActionListener(this);
        add(figuresFileSaveButton);

        // The default drawing tool is the tool for drawing circles
        drawingPanel.activeTool = new CircleTool(drawingPanel);
    }

    // Action performing method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == figuresFileOpenButton)
        {
            java.util.List<Figure> tempFigures = new ArrayList<>();

            JFileChooser fileOpener = new JFileChooser();
            fileOpener.showOpenDialog(this);

            File file = fileOpener.getSelectedFile();
            if (file != null)
            {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    while (true)
                    {
                        // Sequentially reading the shapes from the opened file to a figures list
                        FigureType figType = (FigureType) ois.readObject();
                        Figure fig = (Figure) ois.readObject();
                        switch (figType)
                        {
                            case FigureType.Circle:
                                tempFigures.add(Circle.getCopy(fig));
                                break;
                            case FigureType.Ellipse:
                                tempFigures.add(Ellipse.getCopy(fig));
                                break;
                            case FigureType.Rectangle:
                                tempFigures.add(Figures.Rectangle.getCopy(fig));
                                break;
                            case FigureType.Square:
                                tempFigures.add(Square.getCopy(fig));
                                break;
                            case FigureType.Triangle:
                                tempFigures.add(Triangle.getCopy(fig));
                                break;
                        }
                    }
                }
                catch (EOFException ex)
                {
                    // Rewriting the list of drawn shapes
                    drawingPanel.drawnFigures = tempFigures;

                    // Redrawing the image of the drawn shapes
                    Graphics g = drawingPanel.drawedFiguresImage.getGraphics();
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, DrawingPanel.width, DrawingPanel.height);

                    for (Figure fig : tempFigures)
                        fig.paint(g);
                    drawingPanel.repaint();
                }
                catch (Exception ex)
                {
                    System.out.println("Чёто пошло не так");
                }
            }
        }
        else if (e.getSource() == figuresFileSaveButton)
        {
            JFileChooser fileSaver = new JFileChooser();
            int result = fileSaver.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileSaver.getSelectedFile();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

                    // Just putting the already drawn shapes into the file
                    for (Figure fig : drawingPanel.drawnFigures)
                    {
                        oos.writeObject(fig.getFigureType());
                        oos.writeObject(fig);
                    }
                    oos.flush();
                    oos.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}