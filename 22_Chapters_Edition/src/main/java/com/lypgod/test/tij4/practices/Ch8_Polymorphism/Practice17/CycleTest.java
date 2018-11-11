package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice17;

/**
 * Created by liuyp on 16-10-9.
 */
class Cycle {
    void ride() {
        System.out.println("Cycle ride.");
    }
}

class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Unicycle ride.");
    }

    void balance() {
        System.out.println("Unicycle balance.");
    }
}

class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Bicycle ride.");
    }

    void balance() {
        System.out.println("Bicycle balance.");
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
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        for (Cycle c : cycles) {
//            c.balance;
        }
    }
}
