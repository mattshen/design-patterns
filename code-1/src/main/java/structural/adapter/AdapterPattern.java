package structural.adapter;

/**
 * The purpose is adapting, bridging the gap between the required form and provided form
 */

//required form
interface Adapter {
    void operation();
}

//bridging the gap
class ConcreteAdapter implements Adapter {
    private static Adaptee adaptee;

    public ConcreteAdapter() {
        this.adaptee = new Adaptee();
    }

    public void operation() {
        this.adaptee.adaptedOperation();
    }
}

//actual form
class Adaptee {
    void adaptedOperation() {
        System.out.println("Doing real work");
    }
}


public class AdapterPattern {
    /**
     * This method only respects Adapter interface
     */
    public static void doSomeWork(Adapter adapter) {
        adapter.operation();
    }

    public static void main(String[] args) {
        doSomeWork(new ConcreteAdapter());
    }
}