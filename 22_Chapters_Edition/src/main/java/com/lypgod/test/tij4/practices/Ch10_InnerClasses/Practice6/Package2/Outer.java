package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice6.Package2;

import com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice6.Package1.Interface1;

/**
 * Created by liuyp on 16-10-11.
 */
public class Outer {
    protected class Inner implements Interface1 {
        public Inner() {}
        @Override
        public void method1() {
            System.out.println("Interface method1.");
        }
    }
}
