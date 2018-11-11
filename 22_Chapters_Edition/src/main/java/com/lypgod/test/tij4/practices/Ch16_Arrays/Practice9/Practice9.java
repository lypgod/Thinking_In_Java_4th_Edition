package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice9;

import java.util.ArrayList;
import java.util.List;

class Banana {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Banana " + id; }
}

class Peel<T> {
    private T t;
    private static long counter;
    private final long id = counter++;
    public Peel(T t) { this.t = t; }
    public String toString() { return "Peel " + id + " " + t.toString(); }
}
public class Practice9 {
    public static void main(String[] args) {
        // error: generic array creation:
        // Peel<Banana>[] peels = new Peel<Banana>[10];
        List<Peel<Banana>> peels = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            peels.add(new Peel<>(new Banana()));
        System.out.println(peels);
        System.out.println("peels.get(0).getClass(): " + peels.get(0).getClass());
    }
}
