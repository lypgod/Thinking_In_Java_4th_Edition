//: net/mindview/util/CollectionData.java
// A Collection filled with data using a generator object.
package com.lypgod.test.tij4.practices.Ch17_Containers.Practice29;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    // A generic convenience method:
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
} ///:~
