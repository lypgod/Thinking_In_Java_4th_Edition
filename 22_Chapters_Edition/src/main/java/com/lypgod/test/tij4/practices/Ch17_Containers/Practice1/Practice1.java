package com.lypgod.test.tij4.practices.Ch17_Containers.Practice1;

import com.lypgod.test.tij4.practices.Ch17_Containers.Countries;

import java.util.*;

public class Practice1 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        List<String> ll = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            al.add(Countries.DATA[i][0]);
            ll.add(Countries.DATA[i][1]);
        }
        System.out.println(al);
        System.out.println(ll);

        Collections.sort(al);
        Collections.sort(ll);
        System.out.println("Countries: " + al);
        System.out.println("Capitals: " + ll);

        for (int i = 0; i < 2; i++) {
            Collections.shuffle(al);
            Collections.shuffle(ll);
            System.out.println("Countries " + i + ": " + al);
            System.out.println("Capitals " + i + ": " + ll);
        }


        List<String> al2 = new ArrayList<>();
        List<String> ll2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            al2.add(Countries.DATA[i][0]);
            ll2.add(Countries.DATA[i][1]);
        }

        for (int i = 0; i < 5; i++) {
            Collections.shuffle(al2);
            Collections.shuffle(ll2);
            System.out.println("Countries " + i + ": " + al2);
            System.out.println("Capitals " + i + ": " + ll2);
            Collections.sort(al2);
            Collections.sort(ll2);
        }
    }
}
