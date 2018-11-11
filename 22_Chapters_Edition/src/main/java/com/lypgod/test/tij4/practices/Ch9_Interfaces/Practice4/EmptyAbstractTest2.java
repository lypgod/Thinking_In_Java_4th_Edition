package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice4;

/**
 * Created by liuyp on 16-10-9.
 */
abstract class Base2 {
    abstract void print();
}

class Extended2 extends Base2 {
    @Override
    void print(){
        System.out.println("Extended2 print().");
    }
}
public class EmptyAbstractTest2 {
    static void handle(Base2 base2) {
        base2.print();
    }

    public static void main(String[] args) {
        Extended2 extended2 = new Extended2();
        EmptyAbstractTest2.handle(extended2);
    }
}