package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice4;//: typeinfo/Shapes.java

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Shape shape = new Rhomboid();
        if (shape instanceof Rhomboid) System.out.println(((Rhomboid) shape).toString());
        if (shape instanceof Circle) System.out.println(((Circle) shape).toString());
    }
}