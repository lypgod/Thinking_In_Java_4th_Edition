package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice19;

/**
 * Created by liuyp on 16-10-8.
 */
class Blank {

}
public class BlankFinalTest {
    final Blank blank;

    {
        blank = new Blank();
    }

    public static void main(String[] args) {
        BlankFinalTest blankFinalTest = new BlankFinalTest();
//        blankFinalTest.blank = new Blank();
    }
}
