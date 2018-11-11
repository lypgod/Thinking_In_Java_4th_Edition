package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice11;//: reusing/Detergent.java
// Inheritance syntax & properties.

class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

public class Detergent {
    private Cleanser cleanser = new Cleanser();
    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        cleanser.append(" Detergent.scrub()");
        cleanser.scrub();
    }

    // Add methods to the interface:
    public void foam() {
        cleanser.append(" foam()");
    }

    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x.cleanser);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}
/* Output:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*///:~
