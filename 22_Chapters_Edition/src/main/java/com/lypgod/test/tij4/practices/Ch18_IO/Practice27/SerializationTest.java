package com.lypgod.test.tij4.practices.Ch18_IO.Practice27;

import java.io.*;
import java.util.Random;

class A implements Serializable {
    private int i;

    A(int i) {
        this.i = i;
    }

    public String toString() {
        return "A:" + i;
    }
}

class B implements Serializable {
    private char c;
    private A a;

    B(char c, A a) {
        this.c = c;
        this.a = a;
    }

    public String toString() {
        return "B:" + c + " " + a;
    }
}

public class SerializationTest {
    private static Random rand = new Random();

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        B b = new B('x', new A(rand.nextInt(100)));
        System.out.println("b: " + b);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("STest.out"));
        out.writeObject(b);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("STest.out"));
        B b2 = (B) in.readObject();
        System.out.println("b2: " + b2);
    }
}
