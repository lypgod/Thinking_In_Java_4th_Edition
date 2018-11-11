package com.lypgod.test.tij4.practices.Ch18_IO.Practice24;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        // Store and array of double:
        db.put(new double[]{11.11, 42.42, 27.37, 99.99, 143.143, 811.811, 1016.1026});
        // Absolute location read and write:
        System.out.println(db.get(3));
        db.put(3, 1811.1811);
        // Setting a new limit before rewinding the buffer.
        db.flip();
        while (db.hasRemaining()) {
            double d = db.get();
            System.out.println(d);
        }
    }
}
