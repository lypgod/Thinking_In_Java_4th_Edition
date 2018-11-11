package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice8;

class Base {
    Base(int i) {
        System.out.println("Base init: " + i);
    }
}
public class Extended extends Base{
    Extended() {
        super(1);
        System.out.println("Extended init- 1");
    }
    Extended(int i) {
        super(i);
        System.out.println("Extended init: " + i);
    }
}
