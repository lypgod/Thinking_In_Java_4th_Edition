package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice6;//: holding/ListFeatures.java

import java.util.*;

public class ListFeatures {
    public static List<Integer> listOfRandInteger(int length, int n) {
        Random rand = new Random();
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            li.add(rand.nextInt(n));
        return li;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> li = listOfRandInteger(7, 10);
        System.out.println("1: " + li);
        Integer h = rand.nextInt(10);
        li.add(h);
        System.out.println("2: " + li);
        System.out.println("3: " + li.contains(h));
        // removes the first instance equivalent to Integer h:
        li.remove(h);
        System.out.println("3.5: " + li);
        Integer p = li.get(2);
        System.out.println("4: " + p + " " + li.indexOf(p));
        Integer cy = rand.nextInt(10);
        System.out.println("5: " + cy + " " + li.indexOf(cy));
        System.out.println("6: " + li.remove(cy));
        System.out.println("7: " + li.remove(p));
        System.out.println("8: " + li);
        li.add(3, rand.nextInt(10));
        System.out.println("9: " + li);
        List<Integer> sub = li.subList(1, 4);
        System.out.println("sublist: " + sub);
        System.out.println("10: " + li.containsAll(sub));
        // will also sort sub elements within li:
        Collections.sort(sub);
        System.out.println("sorted sublist: " + sub);
        System.out.println("11: " + li.containsAll(sub));
        System.out.println("11.25: " + li);
        // will also shuffle sub elements within li:
        Collections.shuffle(sub, rand);
        System.out.println("11.5: " + li);
        System.out.println("shuffled sublist: " + sub);
        System.out.println("12: " + li.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(li);
        System.out.println("12.5: " + li);
        sub = Arrays.asList(li.get(1), li.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<Integer>(li);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        if (copy.size() > 1) // to avoid out of bounds exception
            copy.set(1, 8); // autoboxing int -> Integer
        System.out.println("16: " + copy);
        if (copy.size() > 2)
            copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + li.isEmpty());
        li.clear();
        System.out.println("19: " + li);
        System.out.println("20: " + li.isEmpty());
        li.addAll(listOfRandInteger(4, 10));
        System.out.println("21: " + li);
        Object[] o = li.toArray();
        System.out.println("22: " + o[3]);
        Integer[] ia = li.toArray(new Integer[0]);
        System.out.println("23: " + ia[3]);
    }
} /* Output:
1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
10: true
sorted subList: [Manx, Mouse, Mutt]
11: true
shuffled subList: [Mouse, Manx, Mutt]
12: true
sub: [Mouse, Pug]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 14
*///:~
