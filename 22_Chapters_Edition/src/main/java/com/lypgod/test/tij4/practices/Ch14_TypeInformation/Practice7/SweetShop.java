package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice7;//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice7.Candy");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Candy");
        }
        System.out.println("After Class.forName(\"Candy\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
