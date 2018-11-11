package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice16;

class Amphibian {
    private static String name;

    Amphibian(String s) {
        name = s;
    }

    private void swim() {
        System.out.println("Amphibian " + name + " swim");
    }

    protected void walk() {
        System.out.println("Amphibian " + name + " walk");
    }

    static void grow(Amphibian amphibian) {
        System.out.println("Amphibian " + name + " grow");
        amphibian.swim();
    }
}

public class Frog extends Amphibian {
    Frog(String s) {
        super(s);
    }

    public static void main(String[] args) {
        Frog frog = new Frog("FF");
        frog.walk();
        Amphibian.grow(frog);
    }
}
