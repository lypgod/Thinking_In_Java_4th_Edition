package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice8;

/**
 * Created by liuyp on 16-10-13.
 */
class MyException extends Exception {
    private String msg;

    MyException(String msg) {
        super(msg);
        System.out.println("MyException()");
        this.msg = msg;
    }

    protected void showMsg() {
        System.out.println("Message from MyException: " + msg);
    }
}

public class ExceptionTest {
    public static void f() throws MyException {
        System.out.println("f()");
        throw new MyException("Ouch from f()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.showMsg();
        }
    }
}
