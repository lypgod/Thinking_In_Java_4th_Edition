package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice23;

class Disposable {
    private static int counter = 0;
    private int id = counter++;
    private boolean disposed;

    Disposable() {
        disposed = false;
    }

    void dispose() {
        disposed = true;
    }

    String checkStatus() {
        return (id + " " + (disposed ? "disposed" : "not disposed"));
    }
}

public class FailingConstructor {
    private Integer[] ia = new Integer[2];
    private static Disposable d0;
    private static Disposable d1;

    FailingConstructor() throws Exception {
        try {
            d0 = new Disposable();
            try {
                ia[2] = 2;    // causes exception thrown and
                // caught in middle try loop
                try {
                    d1 = new Disposable();
                } catch (Exception e) {
                    System.out.println("Caught e in inner try loop");
                    e.printStackTrace(System.err);
                    System.out.println("Failed to create d1");
                }
            } catch (Exception e) {
                System.out.println("Caught e in middle try loop");
                e.printStackTrace(System.err);
                System.out.println("Disposing d0");
                d0.dispose(); // d0 would have been created
            }
        } catch (Exception e) {
            System.out.println("Caught e in outer try loop");
            e.printStackTrace(System.err);
            System.out.println("Failed to create d0");
        }

    }

    public static void main(String[] args) {
        try {
            // the constructor catches its own exceptions:
            FailingConstructor fc = new FailingConstructor();
        } catch (Exception e) {
            System.out.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        }
    }
}
