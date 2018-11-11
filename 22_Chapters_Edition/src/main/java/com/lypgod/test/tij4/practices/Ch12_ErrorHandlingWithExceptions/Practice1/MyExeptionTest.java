package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice1;

/**
 * Created by liuyp on 16-10-13.
 */
class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
        System.out.println("MyException: " + msg);
    }
}
public class MyExeptionTest {
    public static void main(String[] args) {
        try {
            throw new MyException("This is a new exception.");
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
    }
}
