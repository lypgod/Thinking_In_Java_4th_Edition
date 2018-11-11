package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice9;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        for (Object o : sequence.items) {
            System.out.println(o);
        }
    }
}
