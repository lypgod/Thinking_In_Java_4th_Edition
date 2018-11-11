package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice11;

/**
 * Created by liuyp on 16-10-14.
 */
class MyException extends Exception {
    MyException(String msg) {
        super(msg);
    }
}
public class Practice11 {
    private static void g() throws MyException{
        throw new MyException("New Exception1");
    }
    private static void f() throws RuntimeException {
        try {
            g();
        }catch (MyException e) {
            throw new RuntimeException("New Exception2", e);
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (RuntimeException myException2) {
            myException2.printStackTrace();
        }
    }
}
