package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice11;

import java.util.*;

/**
 * Created by liuyp on 16-10-13.
 */
public class CollectionsTest {
    public static void printCollection(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext())
            System.out.println(it.next() + " ");
    }

    public static void main(String[] args) {
        ArrayList<Integer> al =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        LinkedList<Character> ll =
                new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));
        HashSet<Float> hs =
                new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
        TreeSet<Double> ts =
                new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
        LinkedHashSet<Integer> lhs =
                new LinkedHashSet<Integer>(Arrays.asList(11, 22, 33));
        printCollection(al);
        printCollection(ll);
        printCollection(hs);
        printCollection(ts);
        printCollection(lhs);
    }
}
