import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Program main form
public class Form extends JFrame implements ActionListener {
    JButton BtnPrev;
    JButton BtnNext;
    Figures figs;

    int figureIndex = 0;

    // Class constructor figs - List of shapes to draw
    public Form(Figures figs)
    {
        super("Lab_1");
        this.figs = figs;

        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);

        // Changing figure buttons
        BtnPrev = new JButton();
        BtnPrev.addActionListener(this);
        BtnPrev.setText("prev");
        BtnPrev.setBounds(950, 50, 100, 20);
        add(BtnPrev);

        BtnNext = new JButton();
        BtnNext.addActionListener(this);
        BtnNext.setText("next");
        BtnNext.setBounds(1100, 50, 100, 20);
        add(BtnNext);
    }

    // Painting form method
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawRect(30, 80, 900, 900);

        // Drawing current figure onto form space
        if (figs != null)
            figs.content.get(figureIndex).paint(g, new Rectangle(30, 80, 900, 900));
    }

    // Action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Changing current figure index based on which button clicked
        if (e.getSource() == BtnPrev)
        {
            if (figureIndex > 0)
                figureIndex--;
            repaint();
        }
        else if (e.getSource() == BtnNext)
        {
            if (figureIndex < figs.content.size() - 1)
                figureIndex++;
            repaint();
        }
    }
}
