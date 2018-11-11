package com.lypgod.test.tij4.practices.Ch13_Strings.Practice2;//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}

import java.util.*;

public class InfiniteRecursion {
    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);
    }
} ///:~
