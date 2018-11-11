//: polymorphism/shape/Triangle.java
package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice3.shape;

public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
} ///:~
