package structural.adapter;

interface Adapter {
    void operation();
}

class ConcreteAdapter implements Adapter {
    private static Adaptee adaptee;

    public ConcreteAdapter() {
        this.adaptee = new Adaptee();
    }

    public void operation() {
        this.adaptee.adaptedOperation();
    }
}

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