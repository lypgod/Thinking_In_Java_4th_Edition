package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice1;

class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Unicycle ride.");
    }
}

class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Bicycle ride.");
    }
}

class Tricycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Tricycle ride.");
    }
}

public class CycleTest {
    static void ride(Cycle cycle) {
        cycle.ride();
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
