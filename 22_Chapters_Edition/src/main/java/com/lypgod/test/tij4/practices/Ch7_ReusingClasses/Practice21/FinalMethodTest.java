package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice21;

/**
 * Created by liuyp on 16-10-8.
 */
class FinalMethod {
    void f() {

    }
    final void g() {

    }
}
public class FinalMethodTest extends FinalMethod {
    @Override
    void f() {

    }
//    @Override
//    void g(){ }
}
