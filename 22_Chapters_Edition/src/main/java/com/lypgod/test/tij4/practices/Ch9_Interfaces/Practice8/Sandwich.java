//: polymorphism/Sandwich.java
// Order of constructor calls.
package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice8;

interface FastFood {
  Bread getBread();
  Cheese getCheese();
}

class Meal {
  Meal() { System.out.println("Meal()"); }
}

class Bread {
  Bread() { System.out.println("Bread()"); }
}

class Cheese {
  Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
  Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
  Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
  PortableLunch() { System.out.println("PortableLunch()");}
}

public class Sandwich extends PortableLunch implements FastFood {
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() { System.out.println("Sandwich()"); }
  public static void main(String[] args) {
    Sandwich sandwich = new Sandwich();
    sandwich.getBread();
    sandwich.getCheese();
  }

  @Override
  public Bread getBread() {
    return b;
  }

  @Override
  public Cheese getCheese() {
return c;
  }
} /* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*///:~
