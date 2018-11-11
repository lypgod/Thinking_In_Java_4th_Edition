package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice5;

/**
 * Created by liuyp on 16-10-13.
 */
public class Practice5 {
    private static int[] ia = new int[2];
    static int x = 5;

    public static void main(String[] args) {
        while (true) {
            try {
                ia[x] = 1;
                System.out.println(ia[x]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Caught ArrayIndexOutOfBoundsException " + e.getMessage());
                x--;
            } finally {
                System.out.println("Are we done yet?");
            }
        }
        System.out.println("Now, we're done.");
    }
}
