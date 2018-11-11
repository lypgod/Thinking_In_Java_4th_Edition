package com.lypgod.test.tij4.practices.Ch15_Generics.Practice14;//: generics/BasicGeneratorDemo.java

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }
}

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
