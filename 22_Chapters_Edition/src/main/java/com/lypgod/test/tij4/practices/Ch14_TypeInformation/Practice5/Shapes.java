package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice5;//: typeinfo/Shapes.java

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
    private static void rotate(Shape shape) {
        if (!(shape instanceof Circle)) {
            System.out.println(shape + " rotated.");
        }
    }
    public static void main(String[] args) {
        for (Shape s: new Shape[] {new Circle(), new Square(), new Triangle(), new Rhomboid()}) {
            rotate(s);
        }
    }
}