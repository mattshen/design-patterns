package structural.proxy;

public class Proxy implements Subject {

    private Subject realObj;

    public Proxy() {
        realObj = new RealObject();
    }

    public void request() {
        // can do some extra work before calling realObj
        // call realObj to do the work
        realObj.request();
        // can do some extra work after calling realObj
    }
}