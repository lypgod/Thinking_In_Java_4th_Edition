package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice10;

class Component1 {
    Component1(int i) {
        System.out.println("Component1 init. " + i);
    }
}

class Component2 {
    Component2(int i) {
        System.out.println("Component2 init. " + i);
    }
}

class Component3 {
    Component3(int i) {
        System.out.println("Component3 init. " + i);
    }
}

class Root {
    Component1 component1 = new Component1(1);
    Component2 component2 = new Component2(1);
    Component3 component3 = new Component3(1);

    Root(int i) {
        System.out.println("Root init " + i);
    }
}

public class Stem extends Root {
    Component1 component1 = new Component1(2);
    Component2 component2 = new Component2(2);
    Component3 component3 = new Component3(2);

    Stem(int i) {

        super(i);
        System.out.println("Stem init. " + i);
    }

    public static void main(String[] args) {
        Stem stem = new Stem(3);
    }
}
