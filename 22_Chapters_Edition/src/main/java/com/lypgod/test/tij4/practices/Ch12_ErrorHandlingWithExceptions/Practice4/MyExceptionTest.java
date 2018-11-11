package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice4;

/**
 * Created by liuyp on 16-10-13.
 */
class MyException extends Exception {
    String msg;
    MyException(String msg) {
        super(msg);
        this .msg = msg;
    }
    void showMsg() {
        System.out.println(msg);
    }
}
public class MyExceptionTest {
    public static void main(String[] args) {
        try {
            throw new MyException("This is a new exception.");
        } catch (MyException e) {
            e.showMsg();
        }
    }
}
