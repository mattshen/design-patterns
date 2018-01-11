package structural.proxy;

/**
 * Proxying/representing purpose.
 * controlling access to another object.
 *
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}