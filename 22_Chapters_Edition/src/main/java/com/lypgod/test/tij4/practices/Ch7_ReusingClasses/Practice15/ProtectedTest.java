package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice15;

import com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice15.Package.Packaged;

class Extended extends Packaged {
    public void packageProtected() {
        super.packageProtected();
    }
}

public class ProtectedTest {
    public static void main(String[] args) {
        Packaged packaged = new Packaged();
//        packaged.packageProtected();
        Extended extended = new Extended();
        extended.packageProtected();
    }
}
