package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice4;

import java.util.*;

/**
 * Created by liuyp on 16-10-13.
 */

class Generator {
    int key = 0;

    public String next() {
        switch (key) {
            default:
            case 0:
                key++;
                return "1Snow White";
            case 1:
                key++;
                return "2Bashful";
            case 2:
                key++;
                return "3Doc";
            case 3:
                key++;
                return "4Dopey";
            case 4:
                key++;
                return "5Grumpy";
            case 5:
                key++;
                return "6Happy";
            case 6:
                key++;
                return "7Sleepy";
            case 7:
                key = 0;
                return "8Sneezy";
        }
    }

    public void fillA(String[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = next();
    }

    public Collection fill(Collection<String> c, int n) {
        for (int i = 0; i < n; i++) c.add(next());
        return c;
    }
}

public class Practice4 {
    public static void main(String[] args) {
        String[] a = new String[10];
        new Generator().fillA(a);
        for (String s : a) System.out.print(s + ", ");
        System.out.println();
        System.out.println(new Generator().fill(new ArrayList<String>(), 10));
        System.out.println(new Generator().fill(new LinkedList<String>(), 10));
        System.out.println(new Generator().fill(new HashSet<String>(), 10));
        System.out.println(new Generator().fill(new LinkedHashSet<String>(), 10));
        System.out.println(new Generator().fill(new TreeSet<String>(), 10));

//        System.out.println("1Snow White".hashCode() + ", " + "2Bashful".hashCode() + ", " + "3Doc".hashCode() + ", " + "4Dopey".hashCode() + ", "
//                + "5Grumpy".hashCode() + ", " + "6Happy".hashCode() + ", " + "7Sleepy".hashCode() + ", " + "8Sneezy".hashCode());
    }
}
