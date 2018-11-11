package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice8;

/**
 * Created by liuyp on 16-10-12.
 */
public class Outer {
    class Inner {
        private int i;
    }

    public void main(String[] args) {
//        i = 3;
        new Inner().i = 3;
    }
}

