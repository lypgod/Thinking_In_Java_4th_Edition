package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice3;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private List<Object> items = new ArrayList<Object>();

    private class SequenceSelector implements Selector {
        private int current;

        @Override
        public boolean end() {
            return current == items.size();
        }

        @Override
        public Object current() {
            return items.get(current);
        }

        @Override
        public void next() {
            current++;
        }
    }

    private Selector getSelector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 100; i++)
            sequence.items.add(Integer.toString(i));
        Selector selector = sequence.getSelector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
