//: net/mindview/util/ThreeTuple.java
package com.lypgod.test.tij4.practices.Ch15_Generics.Practice3;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
} ///:~
