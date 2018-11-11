package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice6;

import com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice6.Package1.AnInterface;
import com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice6.Package2.AnInterfaceImpl;

/**
 * Created by liuyp on 16-10-9.
 */
public class Tester {
    public static void main(String[] args) {
        AnInterface anInterface = new AnInterfaceImpl();
        anInterface.method1();
        anInterface.method2();
        anInterface.method3();
    }
}
