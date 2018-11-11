package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice7;

import java.util.ArrayList;
import java.util.List;

class MyClass {
    public static int counter = 0;
    private int id = counter++;

    public String toString() {
        return String.valueOf(id);
    }
}

public class Practice7 {
    public static void main(String[] args) {
        List<MyClass> myClassList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myClassList.add(new MyClass());
        }

        System.out.println(myClassList);

        List<MyClass> subList = myClassList.subList(2, 8);
        System.out.println(subList);

        myClassList.removeAll(subList);
        System.out.println(myClassList);

    }
}
