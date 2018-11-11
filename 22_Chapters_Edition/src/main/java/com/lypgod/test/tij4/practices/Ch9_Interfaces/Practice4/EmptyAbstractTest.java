package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice4;

/**
 * Created by liuyp on 16-10-9.
 */
abstract class Base {}

class Extended extends Base {
    void print(){
        System.out.println("Extended print().");
    }
}
public class EmptyAbstractTest {
    static void handle(Base base) {
        ((Extended)base).print();
    }

    public static void main(String[] args) {
        Extended extended = new Extended();
        EmptyAbstractTest.handle(extended);
    }
}
