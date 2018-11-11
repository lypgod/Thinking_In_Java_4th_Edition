package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice10;//: arrays/ArrayOfGenerics.java
// It is possible to create arrays of generics.

import java.util.*;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class ArrayOfGenerics {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String[] args) {
        List<List<String>> lls = new ArrayList<>();
        // lls = (List<List<String>>)l; // error: inconvertible types
        lls.add(new ArrayList<String>());
//        List<Object> lo = new ArrayList<>();
        // lo = lls; // error: incompatible types
        // Compile-time warning eliminated:
        List<List<BerylliumSphere>> llb = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            llb.add(new ArrayList<BerylliumSphere>());
            for(int j = 0; j < 2; j++)
                llb.get(i).add(new BerylliumSphere());
        }
        System.out.println(llb);
//        List<String>[] ls;
//        List[] la = new List[10];
//        ls = (List<String>[]) la; // "Unchecked" warning
//        ls[0] = new ArrayList<String>();
//        // Compile-time checking produces an error:
//        //! ls[1] = new ArrayList<Integer>();
//
//        // The problem: List<String> is a subtype of Object
//        Object[] objects = ls; // So assignment is OK
//        // Compiles and runs without complaint:
//        objects[1] = new ArrayList<Integer>();
//
//        // However, if your needs are straightforward it is
//        // possible to create an array of generics, albeit
//        // with an "unchecked" warning:
//        List<BerylliumSphere>[] spheres =
//                (List<BerylliumSphere>[]) new List[10];
//        for (int i = 0; i < spheres.length; i++)
//            spheres[i] = new ArrayList<BerylliumSphere>();
    }
} ///:~
