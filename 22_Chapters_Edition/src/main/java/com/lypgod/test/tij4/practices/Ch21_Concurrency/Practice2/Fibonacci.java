package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice2;//: generics/FibonacciTest.java

// Generate a Fibonacci sequence.
interface Generator<T> {
    T next();
}

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2)
            return 1;
        return fib(n - 2) + fib(n - 1);
    }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~
