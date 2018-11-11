package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice2;

/**
 * Created by liuyp on 16-10-13.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        Object s = null;
        try {
            s.hashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
