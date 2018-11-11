//: typeinfo/toys/ToyTest.java
// Testing class Class.
package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice19;

import java.lang.reflect.InvocationTargetException;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {
    }

    Toy(Integer i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    public static void main(String[] args) {
        try {
            Toy.class.getDeclaredConstructor(Integer.class).newInstance(1);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}