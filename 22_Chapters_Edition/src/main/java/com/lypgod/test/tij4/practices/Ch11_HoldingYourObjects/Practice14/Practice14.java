package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice14;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by liuyp on 16-10-13.
 */
public class Practice14 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
        for(Integer i : x) {
            ListIterator<Integer> it = list1.listIterator((list1.size())/2);
            it.add(i);
            System.out.println(list1);
        }
    }
}
