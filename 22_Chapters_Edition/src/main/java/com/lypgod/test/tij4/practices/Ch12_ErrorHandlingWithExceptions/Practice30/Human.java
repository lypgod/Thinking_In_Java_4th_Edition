package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice30;//: exceptions/Human.java
// Catching exception hierarchies.

class Annoyance extends RuntimeException {
}

class Sneeze extends Annoyance {
}

public class Human {
    public static void main(String[] args) {
        // Catch the exact type:
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
        // Catch the base type:
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
} /* Output:
Caught Sneeze
Caught Annoyance
*///:~
