//: polymorphism/shape/Circle.java
package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice3.shape;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void amend() {
        System.out.println("Circle.amend()");
    }
} ///:~
