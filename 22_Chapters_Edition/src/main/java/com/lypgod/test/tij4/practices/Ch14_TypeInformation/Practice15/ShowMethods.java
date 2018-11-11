package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice15;//: typeinfo/ShowMethods.java
// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class.
// {Args: ShowMethods}

import java.lang.reflect.*;
import java.util.regex.*;

public class ShowMethods {
    private static Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");

    public static void main(String[] args) {
        if (args.length < 1) {
            String usage = "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
            System.out.println(usage);
            System.exit(0);
        }
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods)
                    System.out.println(
                            p.matcher(method.toString()).replaceAll(""));
                for (Constructor ctor : ctors)
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            } else {
                for (Method method : methods)
                    if (method.toString().contains(args[1])) {
                        System.out.println(
                                p.matcher(method.toString()).replaceAll(""));
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(
                                ctor.toString()).replaceAll(""));
                    }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
} /* Output:
public static void main(String[])
public native int hashCode()
public final native Class getClass()
public final void wait(long,int) throws InterruptedException
public final void wait() throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
*///:~
