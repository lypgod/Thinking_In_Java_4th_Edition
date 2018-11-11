package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice5;

/**
 * Created by liuyp on 16-10-9.
 */
class Cycle {
    int wheels;

    void ride() {
        System.out.println("Cycle ride.");
    }

    int wheels() {
        return wheels;
    }
}

class Unicycle extends Cycle {
    Unicycle() {
        super.wheels = 1;
    }

    @Override
    void ride() {
        System.out.println("Unicycle ride.");
    }
}

class Bicycle extends Cycle {
    Bicycle() {
        super.wheels = 2;
    }

    @Override
    void ride() {
        System.out.println("Bicycle ride.");
    }
}

class Tricycle extends Cycle {
    Tricycle() {
        super.wheels = 3;
    }

    @Override
    void ride() {
        System.out.println("Tricycle ride.");
    }
}

public class CycleTest {
    static void ride(Cycle cycle) {
        System.out.println(cycle.wheels());
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        CycleTest.ride(cycle);
        CycleTest.ride(unicycle);
        CycleTest.ride(bicycle);
        CycleTest.ride(tricycle);

    }
}
