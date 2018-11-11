//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice31;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator implements Iterable<Shape> {
    private Random rand = new Random();

    public Shape make() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    private Shape[] shapes;

    RandomShapeGenerator(int n) {
        shapes = new Shape[n];
        for (int i = 0; i < n; i++)
            shapes[i] = make();

    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            public boolean hasNext() {
                return index < shapes.length;
            }

            public Shape next() {
                return shapes[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        RandomShapeGenerator rsg = new RandomShapeGenerator(20);
        for (Shape s : rsg)
            System.out.println(s);
    }
} ///:~
