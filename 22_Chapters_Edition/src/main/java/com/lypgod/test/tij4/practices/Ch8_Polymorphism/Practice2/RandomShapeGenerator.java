//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice2;

import com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice2.shape.Circle;
import com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice2.shape.Shape;
import com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice2.shape.Square;
import com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice2.shape.Triangle;

import java.util.Random;

public class RandomShapeGenerator {
    private Random rand = new Random(47);

    public Shape next() {
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
} ///:~
