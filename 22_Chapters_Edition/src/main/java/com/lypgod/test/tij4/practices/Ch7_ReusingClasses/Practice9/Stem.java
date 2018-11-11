package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice9;

class Component1 {
    Component1() {
        System.out.println("Component1 init.");
    }
}

class Component2 {
    Component2() {
        System.out.println("Component2 init.");
    }
}

class Component3 {
    Component3() {
        System.out.println("Component3 init.");
    }
}

class Root {
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    Root() {
        System.out.println("Root init");
    }
}

public class Stem extends Root {
    Component1 component1 = new Component1();
    Component2 component2 = new Component2();
    Component3 component3 = new Component3();

    Stem() {
        System.out.println("Stem init.");
    }

    public static void main(String[] args) {
        Stem stem = new Stem();
    }
}
