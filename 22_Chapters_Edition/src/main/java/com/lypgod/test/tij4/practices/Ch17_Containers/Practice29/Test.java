package com.lypgod.test.tij4.practices.Ch17_Containers.Practice29;

public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam tp);
} ///:~
