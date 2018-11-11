package com.lypgod.test.tij4.practices.Ch15_Generics.Practice7;

import java.util.Iterator;

interface Generator<T> {
    T next();
}

public class Fibonacci implements Generator<Integer>, Iterable<Integer> {
    private int count = 0;
    private int m;

    public Fibonacci() {
    }

    public Fibonacci(int m) {
        this.m = m;
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++)
            System.out.print(gen.next() + " ");
        System.out.println();
        Iterator it = new Fibonacci(20).iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return m > 0;
            }

            public Integer next() {
                m--;
                return Fibonacci.this.next();
            }

            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

}
