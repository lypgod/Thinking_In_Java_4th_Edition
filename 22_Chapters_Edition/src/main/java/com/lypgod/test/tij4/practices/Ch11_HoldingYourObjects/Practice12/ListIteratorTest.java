package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by liuyp on 16-10-13.
 */
public class ListIteratorTest {
    static List<Integer> list1 = new ArrayList<Integer>() { {add(1); add(2); add(3);} };
    static List<Integer> list2 = new ArrayList<>(3);

    public static void main(String[] args) {
        ListIterator listIterator = list1.listIterator(list1.size());
        while (listIterator.hasPrevious()) {
            list2.add((Integer) listIterator.previous());
        }
        System.out.println(list2);
    }
}
