//: polymorphism/shape/Circle.java
package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice2.shape;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }
} ///:~
