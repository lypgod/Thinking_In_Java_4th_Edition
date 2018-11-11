package com.lypgod.test.tij4.practices.Ch18_IO.Practice29;//: io/Blip3.java
// Reconstructing an externalizable object.

import java.io.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s; // No initialization

    public Blip3() {
        System.out.print("Blip3 Constructor");
        // s, i not initialized
    }

    public Blip3(String x, int a) {
        System.out.print("Blip3(String x, int a)");
        s = x;
        i = a;
        // s & i initialized only in non-default constructor.
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.print("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        System.out.print(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.print("Saving object:");
        o.writeObject(b3);
        o.close();
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.print("Recovering b3:");
        b3 = (Blip3) in.readObject();
        System.out.print(b3);
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.print("Blip3.writeExternal");
        // You must do this:
//        out.writeObject(s);
//        out.writeInt(i);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.print("Blip3.readExternal");
        // You must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }
} /* Output:
Constructing objects:
Blip3(String x, int a)
A String 47
Saving object:
Blip3.writeExternal
Recovering b3:
Blip3 Constructor
Blip3.readExternal
A String 47
*///:~
