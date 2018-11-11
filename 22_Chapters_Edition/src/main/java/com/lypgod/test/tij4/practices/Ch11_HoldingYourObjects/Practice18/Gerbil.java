package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice18;

import java.util.*;

/**
 * Created by liuyp on 16-10-13.
 */
public class Gerbil {
    private int gerbilNumber;

    public Gerbil(int i) {
        gerbilNumber = i;
    }

    public void hop() {
        System.out.println("Gerbil " + gerbilNumber + " hops");
    }

    public static void main(String[] args) {
        Map<String, Gerbil> gerbils = new HashMap<>();
        gerbils.put("Fuzzy", new Gerbil(0));
        gerbils.put("Spot", new Gerbil(1));
        gerbils.put("Speedy", new Gerbil(2));
        gerbils.put("Dopey", new Gerbil(3));
        gerbils.put("Sleepy", new Gerbil(4));
        gerbils.put("Happy", new Gerbil(5));
        gerbils.put("Funny", new Gerbil(6));
        gerbils.put("Silly", new Gerbil(7));
        gerbils.put("Goofy", new Gerbil(8));
        gerbils.put("Wowee", new Gerbil(9));
        System.out.println("HashMap: " + gerbils);
        System.out.println();
        Set<String> sortedKeys = new TreeSet<>(gerbils.keySet());
        System.out.println("sortedKeys: " + sortedKeys);
        System.out.println();
        Map<String, Gerbil> sortedGerbils = new LinkedHashMap<>();
        for(String s : sortedKeys) {
            System.out.print("Adding " + s + ", ");
            sortedGerbils.put(s, gerbils.get(s));
        }
        System.out.println();
        System.out.println();
        System.out.println("LinkedHashMap: " + sortedGerbils);
        System.out.println();
        // or, just:
        Map<String, Gerbil> sortedGerbils2 = new TreeMap<>(gerbils);
        System.out.println("TreeMap: " + sortedGerbils2);
    }
}
