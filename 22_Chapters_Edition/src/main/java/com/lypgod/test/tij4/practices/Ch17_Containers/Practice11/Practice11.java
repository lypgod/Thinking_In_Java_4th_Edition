package com.lypgod.test.tij4.practices.Ch17_Containers.Practice11;

import java.util.PriorityQueue;
import java.util.Random;

class A implements Comparable<A> {
    private Integer i;

    A() {
        i = new Random().nextInt(100);
    }

    @Override
    public int compareTo(A o) {
        return o.i - this.i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class Practice11 {
    public static void main(String[] args) {
        PriorityQueue<A> pt = new PriorityQueue<>();
        for (int i = 0; i < 20; i++) {
            pt.add(new A());
        }
        int size = pt.size();
        for (int i = 0; i < size; i++) {
            System.out.print(pt.poll() + " ");
        }
    }
}
