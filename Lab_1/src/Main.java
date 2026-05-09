// The class of the entry point to the program
public class Main {
    public static void main(String[] args) {
        // Adding figures to the figures list
        Figures figs = new Figures();
        figs.add(new Triangle(600, 300, 50));
        figs.add(new Square(300));
        figs.add(new Ellipse(400, 100));
        figs.add(new Rectangle(600, 300));
        figs.add(new Circle(200));

        // Creating a form
        Form form = new Form(figs);
        form.setVisible(true);
    }
}