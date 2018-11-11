package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice13;

/**
 * Created by liuyp on 16-10-10.
 */
interface First {
    void first();
}

interface Second extends First {
    void second();
}

interface Third extends First {
    void third();
}

interface Fourth extends Second, Third {
    void fourth();
}

class MultiInherit implements Fourth {

    @Override
    public void first() {

    }

    @Override
    public void second() {

    }

    @Override
    public void third() {

    }

    @Override
    public void fourth() {

    }
}

public class MultiInheritTest {
    public static void main(String[] args) {
        MultiInherit multiInherit = new MultiInherit();

        ((First)multiInherit).first();

        ((Second) multiInherit).first();
        ((Second)multiInherit).second();

        ((Third)multiInherit).first();
        ((Third)multiInherit).third();

        ((Fourth)multiInherit).first();
        ((Fourth)multiInherit).second();
        ((Fourth)multiInherit).third();
        ((Fourth)multiInherit).fourth();
    }
}
