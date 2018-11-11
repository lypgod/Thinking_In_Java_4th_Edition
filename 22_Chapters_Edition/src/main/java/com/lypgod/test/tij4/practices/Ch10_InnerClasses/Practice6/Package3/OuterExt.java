package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice6.Package3;

import com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice6.Package1.Interface1;
import com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice6.Package2.Outer;

/**
 * Created by liuyp on 16-10-11.
 */
public class OuterExt extends Outer {
    static Interface1 getInner() {
        return new Outer().new Inner();
    }

    public static void main(String[] args) {
        getInner().method1();
    }
}
