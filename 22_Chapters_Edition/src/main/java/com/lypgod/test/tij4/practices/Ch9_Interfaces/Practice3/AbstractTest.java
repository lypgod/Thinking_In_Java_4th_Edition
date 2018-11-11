package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice3;

/**
 * Created by liuyp on 16-10-9.
 */
abstract class Base {
    abstract void print();
    Base() {
        print();
    }
}
class Extended extends Base {
    int i = 22;
    @Override
    void print() {
        System.out.println(i);
    }
}
public class AbstractTest {
    public static void main(String[] args) {
        Extended extended = new Extended();
        extended.print();
    }
}
