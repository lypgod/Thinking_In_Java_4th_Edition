package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice21;//: typeinfo/SimpleProxyDemo.java

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        proxied.doSomething();
        doCount++;
        System.out.println("doSomething: " + doCount);
    }

    public void somethingElse(String arg) {
        proxied.somethingElse(arg);
        sECount++;
        System.out.println("somethingElse: " + sECount);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
        consumer(new SimpleProxy(new RealObject()));
        consumer(new SimpleProxy(new RealObject()));
        consumer(new SimpleProxy(new RealObject()));
    }
}