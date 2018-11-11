package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice28;

/**
 * Created by liuyp on 16-10-13.
 */
class MyException extends RuntimeException {
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
        throw new MyException("This is a new exception.");
    }
}
