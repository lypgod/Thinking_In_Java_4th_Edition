package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice26;

class Outer {
    class OuterInner {
        OuterInner(int i) {
            System.out.println(i);
        }
    }
}

public class Practice26 {
    class Practice26Inner extends Outer.OuterInner {
        Practice26Inner(Outer outer, int i) {
            outer.super(i);
        }
    }

    public static void main(String[] args) {
        Practice26 practice26 = new Practice26();
        practice26.new Practice26Inner(new Outer(), 25);
    }
}
