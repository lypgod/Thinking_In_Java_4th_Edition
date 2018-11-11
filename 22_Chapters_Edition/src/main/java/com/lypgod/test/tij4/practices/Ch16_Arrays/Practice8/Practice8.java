package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice8;
class A{}
public class Practice8<T> {
    T[] a = (T[])new Object[2];
    public static void main(String[] args) {
        String[] sa = new String[2];
        Object[] oa = new Object[3];
        oa[0] = new String("hi");
        oa[1] = 2;
        oa[2] = new A();
        for (int i = 0; i < 3; i++) {
            System.out.println(oa[i] + " - " + oa[i].getClass());
        }
    }
}
