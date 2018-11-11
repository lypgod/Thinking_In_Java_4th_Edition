package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Gerbil {
    private int gerbilNumber;

    Gerbil() {
        gerbilNumber = new Random().nextInt(10);
    }

    void hop() {
        System.out.println("Gerbil #" + gerbilNumber + " hops.");
    }
}

public class ArrayListTest {
    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new Gerbil());
        }
        for (Gerbil g : gerbils) {
            g.hop();
        }
    }
}
