//: net/mindview/util/FourTuple.java
package com.lypgod.test.tij4.practices.Ch15_Generics.Practice16;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ")";
    }
} ///:~
