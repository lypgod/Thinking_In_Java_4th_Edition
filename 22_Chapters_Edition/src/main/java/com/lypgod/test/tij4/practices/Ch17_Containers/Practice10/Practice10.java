package com.lypgod.test.tij4.practices.Ch17_Containers.Practice10;

class T {
}

public class Practice10 {
    public static void main(String[] args) {
        MySortedSet<T> ss = new MySortedSet<T>();
        ss.add(new T());
        ss.add(new T());
        ss.add(new T());
        ss.add(new T());
        System.out.println(ss);
        MySortedSet<Integer> ss2 = new MySortedSet<Integer>();
        ss2.add(6);
        ss2.add(8);
        ss2.add(2);
        ss2.add(4);
        ss2.add(2);
        ss2.add(8);
        System.out.println(ss2);
        MySortedSet<String> ss3 = new MySortedSet<String>();
        ss3.add("three");
        ss3.add("three");
        ss3.add("seven");
        ss3.add("hi");
        ss3.add("two");
        ss3.add("one");
        System.out.println(ss3);
    }
}
