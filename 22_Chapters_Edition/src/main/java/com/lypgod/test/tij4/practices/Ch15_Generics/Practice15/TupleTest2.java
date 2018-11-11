package com.lypgod.test.tij4.practices.Ch15_Generics.Practice15;

import static com.lypgod.test.tij4.practices.Ch15_Generics.Practice15.Tuple.tuple;

class MyClass1 {

}

class MyClass2 {

}

public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<MyClass2, String, Integer> g() {
        return tuple(new MyClass2(), "hi", 47);
    }

    static FourTuple<MyClass1, MyClass2, String, Integer> h() {
        return tuple(new MyClass1(), new MyClass2(), "hi", 47);
    }

    static FiveTuple<MyClass1, MyClass2, String, Integer, Double> k() {
        return tuple(new MyClass1(), new MyClass2(),
                "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        TwoTuple<String, Integer> ttsi2 = f2();
        System.out.println(ttsi2);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}