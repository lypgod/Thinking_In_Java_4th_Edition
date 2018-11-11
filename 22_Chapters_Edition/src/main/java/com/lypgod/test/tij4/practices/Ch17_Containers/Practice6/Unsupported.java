package com.lypgod.test.tij4.practices.Ch17_Containers.Practice6;

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> subList = list.subList(1, 8);
        // Copy of subList:
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            list.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            list.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try {
            list.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }
        try {
            list.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }
        try {
            list.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }
        try {
            list.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }
        // The List.set() method modifies the value but
        // doesn't change the size of the data structure:
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
        // Additional optional List methods:
        try {
            list.add(0, "X");
        } catch (Exception e) {
            System.out.println("List.add(): " + e);
        }
        try {
            list.addAll(0, c2);
        } catch (Exception e) {
            System.out.println("List.addAll(): " + e);
        }
        try {
            list.remove(0);
        } catch (Exception e) {
            System.out.println("List.remove(): " + e);
        }
        try {
            list.removeAll(c2);
        } catch (Exception e) {
            System.out.println("List.removeAll(): " + e);
        }
        try {
            list.retainAll(c2);
        } catch (Exception e) {
            System.out.println("List.retainAll(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiabe Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("unmodifiableLlist()", Collections.unmodifiableList(new ArrayList<>(list)));
    }

}
