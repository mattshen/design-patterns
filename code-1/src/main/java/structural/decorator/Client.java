package structural.decorator;

/**
 * Enriching objects
 * Progressing to final results, similar to Visitor pattern.
 * Dynamically modifying existing responsibilities and behaviors.
 * Good alternative to class inheritance in some cases.
 * Can have a lot of decorators.
 *
 */

public class Client {
    public static void printInfo(Coffee c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }

    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();
        printInfo(c);

        c = new WithMilk(c);
        printInfo(c);

        c = new WithSprinkles(c);
        printInfo(c);
    }
}
