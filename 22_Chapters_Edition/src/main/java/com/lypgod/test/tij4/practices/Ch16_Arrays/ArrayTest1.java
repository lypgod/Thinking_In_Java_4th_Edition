package com.lypgod.test.tij4.practices.Ch16_Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A {
    public int age = 0;
}

public class ArrayTest1 {
    void modArray(int[] l) {
        for (int i = 0; i < l.length; i++) {
            l[i] = 3;
        }
    }

    void modArrayList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 3);
        }
    }

    private void test1(int a) {
        a = 5;
        System.out.println("test1方法中的a=" + a);
    }

    private void test2(Integer a) {
        a = 20;
        System.out.println(a.getClass().hashCode());
        System.out.println("test1方法中的age=" + a);
    }

    private void test3(A a) {
        a.age = 20;
        System.out.println(a);
        System.out.println("test1方法中的age=" + a.age);
    }

    private void test4(BigInteger a) {
        a = new BigInteger("1");
        System.out.println("BigInteger a=" + a);
    }


    public static void main(String[] args) {
//        int[] intArray = new int[] {1,1,1,1,1};
//        List<Integer> intArrayList = new ArrayList<>();
//        intArrayList = Arrays.asList(1,1,1,1,1);
//        ArrayTest1 arrayTest = new ArrayTest1();
//        arrayTest.modArray(intArray);
//        for (int i:intArray) {
//            System.out.print(i + ", ");
//        }
//        System.out.println();
//        arrayTest.modArrayList(intArrayList);
//        System.out.println(intArrayList);
        ArrayTest1 t = new ArrayTest1();
//        int a = 3;
//        t.test1(a);//传递后，test1方法对变量值的改变不影响这里的a
//        System.out.println("main方法中的a=" + a);
//        Integer b = new Integer(10);
//        System.out.println(b.getClass().hashCode());
//        t.test2(b);
//        System.out.println("main方法中的age=" + b);
//        A c = new A();
//        System.out.println(c);
//        c.age = 10;
//        t.test3(c);
//        System.out.println(c);
//        System.out.println("main方法中的age=" + c.age);
        BigInteger a = new BigInteger("2");
        System.out.println(a);
        t.test4(a);
        System.out.println(a);
    }
}
