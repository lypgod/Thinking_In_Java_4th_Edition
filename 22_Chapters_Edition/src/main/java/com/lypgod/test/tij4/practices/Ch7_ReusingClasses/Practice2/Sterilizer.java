package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice2;

/**
 * Created by liuyp on 16-10-8.
 */
public class Sterilizer extends Detergent {
    @Override
    public void scrub() {
        append(" Sterilizer.scrub()");
    }

    public void sterilize() {
        append(" sterilize()");
    }

    public static void main(String[] args) {
        Sterilizer x = new Sterilizer();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        System.out.println(x);
        System.out.println("Testing base class:");
        Detergent.main(args);
    }
}
