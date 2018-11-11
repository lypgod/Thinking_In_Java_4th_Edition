package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice12;

class Component1 {
    Component1() {
        System.out.println("Component1 init.");
    }
    void dispose() { System.out.println("Component1.dispose()"); }
}

class Component2 {
    Component2() {
        System.out.println("Component2 init.");
    }
    void dispose() { System.out.println("Component2.dispose()"); }
}

class Component3 {
    Component3() {
        System.out.println("Component3 init.");
    }
    void dispose() { System.out.println("Component3.dispose()"); }
}

class Root {
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    Root() {
        System.out.println("Root init");
    }
    void dispose() {
        component1.dispose();
        component2.dispose();
        component3.dispose();
        System.out.println("Root2.dispose()");
    }
}

public class Stem extends Root {
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    Stem() {
        System.out.println("Stem init.");
    }
    void dispose() {
        component1.dispose();
        component2.dispose();
        component3.dispose();
        super.dispose();
        System.out.println("Stem2.dispose()");
    }

    public static void main(String[] args) {
        Stem stem = new Stem();try {
            // Code and exception handling...
        } finally {
            stem.dispose();
        }
    }
}
