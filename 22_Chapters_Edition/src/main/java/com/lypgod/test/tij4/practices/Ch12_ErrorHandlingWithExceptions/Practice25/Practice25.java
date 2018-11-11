package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice25;

class BaseException extends Exception{}
class ChildException extends BaseException{}

class A {
    void aMethod() throws Exception {
        throw new Exception();
    }
}
class B extends A {
    @Override
    void aMethod() throws BaseException {
        throw new BaseException();
    }
}
class C extends B {
    @Override
    void aMethod() throws ChildException {
        throw new ChildException();
    }
}
public class Practice25 {
    public static void main(String[] args) {
        A a = new C();
        try {
            a.aMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
