package structural.composite;


import java.util.ArrayList;
import java.util.List;

/**
 * "Component"
 */
interface Graphic
{
    void print();
}

/**
 * "Composite"
 */
class CompositeGraphic implements Graphic
{
    //Collection of child graphics.
    private List<Graphic> childGraphics = new ArrayList<Graphic>();

    //Prints the graphic.
    public void print()
    {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }

    //Adds the graphic to the composition.
    public void add(Graphic graphic)
    {
        childGraphics.add(graphic);
    }

    //Removes the graphic from the composition.
    public void remove(Graphic graphic)
    {
        childGraphics.remove(graphic);
    }
}

/**
 * "Leaf"
 */
class Ellipse implements Graphic
{
    private final String name;
    public Ellipse(String name)
    {
        this.name = name;
    }

    //Prints the graphic.
    public void print()
    {
        System.out.println("Ellipse#" + name);
    }
}

/**
 * Client
 */
public class CompositePattern
{
    public static void main(String[] args)
    {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse("1");
        Ellipse ellipse2 = new Ellipse("2");
        Ellipse ellipse3 = new Ellipse("3");
        Ellipse ellipse4 = new Ellipse("4");

        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();

        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);

        graphic2.add(ellipse4);

        graphic.add(graphic1);
        graphic.add(graphic2);

        //Prints the complete graphic (Four times the string "Ellipse").
        graphic.print();
    }
}
