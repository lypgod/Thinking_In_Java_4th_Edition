package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice3;

/**
 * Created by liuyp on 16-10-13.
 */
public class ArrayIndexOutOfBoundsExceptionTest {

    public static void main(String[] args) {
        String[] strings = new String[]{"aa"};
        try {
            System.out.println(strings[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
