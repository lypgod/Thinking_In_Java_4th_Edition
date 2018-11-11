package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice16;

interface Cycle {
    void ride();
}

public class CycleFactoryTest {
    static private  Cycle getUnicycle() {
        return new Cycle() {
            @Override
            public void ride() {
                System.out.println("Unicycle ride.");
            }
        };
    }
    static private  Cycle getBicycle() {
        return new Cycle() {
            @Override
            public void ride() {
                System.out.println("Bicycle ride.");
            }
        };
    }
    static private  Cycle getTricycle() {
        return new Cycle() {
            @Override
            public void ride() {
                System.out.println("Tricycle ride.");
            }
        };
    }

    private static void rideCycle(Cycle cycle) {
        cycle.ride();
    }

    public static void main(String[] args) {
        rideCycle(getUnicycle());
        rideCycle(getBicycle());
        rideCycle(getTricycle());
    }
}
