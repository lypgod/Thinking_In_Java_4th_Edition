package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice2;//: holding/SimpleCollection.java

import java.util.*;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection c = new HashSet();
//        for (int i = 0; i < 10; i++)
//            c.add(String.valueOf(i)); // Autoboxing
//        1178306109, -1721663081, 1588229, 1554932965, 1934599841, 1615468618, -247835751, 641515282
//        c.add(1178306109);
//        c.add(-1721663081);
//        c.add(1588229);
//        c.add(1554932965);
//        c.add(1934599841);
//        c.add(1615468618);
//        c.add(-247835751);
//        c.add(641515282);
        c.add(1);
        c.add(-2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        c.add(-7);
        c.add(8);
        for (Object i : c)
            System.out.print(i + ", ");
    }
} /* Output:
0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
*///:~
