package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice18;//: exceptions/LostMessage.java
// How an exception can be lost.

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

class ThirdException extends Exception {
    public String toString() {
        return "A third exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            try {
                LostMessage lm = new LostMessage();
                try {
                    lm.f();
                } finally {
                    lm.dispose();
                }
            } finally {
                throw new ThirdException();
            }
        } catch (ThirdException e) {
            System.out.println(e);
        }
    }
} /* Output:
A trivial exception
*///:~
