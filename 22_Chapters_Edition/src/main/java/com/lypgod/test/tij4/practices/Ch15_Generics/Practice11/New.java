//: net/mindview/util/New.java
// Utilities to simplify generic container creation
// by using type argument inference.
package com.lypgod.test.tij4.practices.Ch15_Generics.Practice11;

import java.util.*;

class TestClass {
    void f() {
        System.out.println("TestClass");
    }
}

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    // Examples:
    public static void main(String[] args) {
        Map<TestClass, List<TestClass>> sls = New.map();
        LinkedList<TestClass> lls = New.lList();
        Set<TestClass> ss = New.set();
        Queue<TestClass> qs = New.queue();
        List<TestClass> ls = New.list();
        ls.add(new TestClass());
        ls.add(new TestClass());
        for (TestClass t:ls) {
            t.f();
        }
    }
} ///:~
