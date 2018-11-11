package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class PythonList extends ArrayList {
    List myList = new ArrayList();

    PythonList(List l) {
        myList = l;
    }

    @SuppressWarnings("unchecked")
    PythonList getReversed() {
        ListIterator lit = myList.listIterator(myList.size());
        List reverseMyList = new ArrayList();
        while (lit.hasPrevious()) {
            reverseMyList.add(lit.previous());
        }
        return new PythonList(reverseMyList);
    }
}

public class PythonListTest {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(aList);
        System.out.println(aList.get(4));
        aList.add(6);
        aList.addAll(new ArrayList<>(Arrays.asList(7, 8)));
        System.out.println(aList);
        System.out.println(aList.subList(2, 4));
        PythonList ml = new PythonList(aList);
        System.out.println((ml.getReversed()).myList);
    }
}
