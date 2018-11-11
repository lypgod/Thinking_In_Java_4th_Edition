//: interfaces/interfaceprocessor/Apply.java
package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice11;

public class Apply {
  public static void process(Processor p, Object s) {
    System.out.println("Using Processor " + p.name());
    System.out.println(p.process(s));
  }
} ///:~
