package creational.singleton;

//https://en.wikipedia.org/wiki/Singleton_pattern
public class Demo {

}

final class Singleton {
    //guarantees CPU cache is synchronized with main memory
    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            //guarantee read/write from different thread are sync'ed
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

class Something {

    private Something() {}

    //Initialized when `getInstance` is called
    //class initialization phase is guaranteed by the JLS(Java Language Specification) to be sequential
    private static class LazyHolder {
        static final Something INSTANCE = new Something();
    }

    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }

}