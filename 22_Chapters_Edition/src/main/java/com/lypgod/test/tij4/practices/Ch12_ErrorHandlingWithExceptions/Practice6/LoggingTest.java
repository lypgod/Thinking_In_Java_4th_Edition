package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice6;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by liuyp on 16-10-13.
 */
class LoggingException1 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    LoggingException1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
class LoggingException2 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    LoggingException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LoggingTest {
    public static void main(String[] args) {
        try {
            throw new LoggingException1();
        } catch (LoggingException1 e) {
            e.printStackTrace();
        }
        try {
            throw new LoggingException2();
        } catch (LoggingException2 e) {
            e.printStackTrace();
        }
    }
}
