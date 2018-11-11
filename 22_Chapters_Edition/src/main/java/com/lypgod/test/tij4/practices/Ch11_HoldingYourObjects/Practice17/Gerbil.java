package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
        Map<Integer, Gerbil> gerbilMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            gerbilMap.put(i, new Gerbil(i));
        }

//        Iterator it = gerbilMap.keySet().iterator();
//        while (it.hasNext()) {
//            Integer i = (Integer) it.next();
//            System.out.print("Key:" + i + " ");
//            gerbilMap.get(i).hop();
//        }
        for (Map.Entry<Integer, Gerbil> entry : gerbilMap.entrySet()) {
            System.out.print("Key:" + entry.getKey() + " ");
            entry.getValue().hop();
        }
    }
}
