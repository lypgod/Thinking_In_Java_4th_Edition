package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice7;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by liuyp on 16-10-13.
 */
public class ArrayIndexOutOfBoundsExceptionTest {
    private static Logger logger = Logger.getLogger("LoggingException");

    static void logException(Exception e) { // Exception e argument
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"aa"};
        try {
            System.out.println(strings[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            logException(e);
        }
    }
}
