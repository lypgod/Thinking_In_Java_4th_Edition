package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice10;

class MyException1 extends Exception {
    MyException1(String msg) {
        super(msg);
    }
}
class MyException2 extends Exception {
    MyException2(String msg, Throwable cause) {
        super(msg, cause);
    }
}
public class Practice10 {
    private static void g() throws MyException1{
        throw new MyException1("New Exception1");
    }
    private static void f() throws MyException2 {
        try {
            g();
        }catch (MyException1 e) {
            throw new MyException2("New Exception2", e);
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 myException2) {
            myException2.printStackTrace();
        }
    }
}
