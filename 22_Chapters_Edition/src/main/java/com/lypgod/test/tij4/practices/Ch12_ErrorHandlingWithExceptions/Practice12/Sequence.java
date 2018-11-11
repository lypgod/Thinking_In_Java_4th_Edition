package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice12;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {
    boolean end();

    Object current();

    void next();
}

class TooManyElementsException extends Exception {
    TooManyElementsException(String msg) {
        super(msg);
    }
}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) throws TooManyElementsException {
        if (next < items.length) {
            items[next++] = x;
        } else {
            throw new TooManyElementsException("Too Many Elements!");
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 14; i++)
            try {
                sequence.add(Integer.toString(i));
            } catch (TooManyElementsException e) {
                System.out.println(e.getMessage());
            }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
