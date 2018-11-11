package com.lypgod.test.tij4.practices.Ch17_Containers.Practice7;

import com.lypgod.test.tij4.practices.Ch17_Containers.Countries;

import java.util.*;

public class Practice7 {
    public static void main(String[] args) {
        List<String> countriesArrayList = new ArrayList<>(Countries.names(10));
        List<String> countriesLinkedList = new LinkedList<>(Countries.names(10));
        System.out.println(countriesArrayList);
        System.out.println(countriesLinkedList);
        System.out.println("-----------------------------");
        Iterator alit = countriesArrayList.iterator();
        Iterator llit = countriesLinkedList.iterator();
        while(alit.hasNext()) {
            System.out.println(alit.next() + (alit.hasNext() ? ", " : ""));
        }
        System.out.println();
        while(llit.hasNext()) {
            System.out.println(llit.next() + (llit.hasNext() ? ", " : ""));
        }
        System.out.println("-----------------------------");
        ListIterator allit = countriesArrayList.listIterator();
        for (Object aCountriesLinkedList : countriesLinkedList) {
            allit.add(aCountriesLinkedList);
            allit.next();
        }
        System.out.println(countriesArrayList);
        System.out.println(countriesLinkedList);
        System.out.println("-----------------------------");
        ListIterator lllit = countriesLinkedList.listIterator();
        List<String> countriesArrayList2 = new ArrayList<>(Countries.names(10));
        ListIterator allit2 = countriesArrayList2.listIterator();
        while(lllit.hasPrevious()) lllit.previous();
        while(allit2.hasNext()) allit2.next();
        while(lllit.hasNext()) {
            allit2.add(lllit.next());
            allit2.previous();
            allit2.previous();
        }
        System.out.println(countriesArrayList2);
    }
}
