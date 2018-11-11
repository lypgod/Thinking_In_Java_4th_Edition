package com.lypgod.test.tij4.practices.Ch15_Generics.Practice33;

import java.util.ArrayList;
import java.util.List;

class VariableSizeStack<T> {
    private List<T> storage = new ArrayList<>();

    int getSize() {
        return storage.size();
    }

    public void push(T item) {
        storage.add(item);
    }

    public T pop() {
        return storage.remove(storage.size() - 1);
    }
}

public class GenericCast {
    public static void main(String[] args) {
        VariableSizeStack<String> strings = new VariableSizeStack<>();
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        // Runtime ArrayIndexOutOfBoundsException:
         strings.push("oops"); // Bounds-checking required:
//        if (strings.getIndex() < SIZE) strings.push("oops");
        while (strings.getSize() > 0) {
            System.out.println(strings.pop());
        }
    }
}
