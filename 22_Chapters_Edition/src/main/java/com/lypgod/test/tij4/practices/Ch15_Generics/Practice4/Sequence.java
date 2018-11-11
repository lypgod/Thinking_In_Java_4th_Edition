package com.lypgod.test.tij4.practices.Ch15_Generics.Practice4;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence<T> {
    private List<T> items;

    public void add(T t) {
        items.add(t);
    }

    public Sequence(List<T> list) {
        this.items = list;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.size();
        }

        public T current() {
            return items.get(i);
        }

        public void next() {
            if (i < items.size()) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        Sequence<String> gs = new Sequence<>(ls);
        for (int i = 0; i < 10; i++)
            gs.add(Integer.toString(i));
        Selector selector = gs.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
