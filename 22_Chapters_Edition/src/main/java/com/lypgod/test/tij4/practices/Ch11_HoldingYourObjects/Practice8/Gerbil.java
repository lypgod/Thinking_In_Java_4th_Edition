package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice8;

import java.util.ArrayList;

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
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            gerbils.add(new Gerbil(i));
        for (int i = 0; i < 10; i++)
            gerbils.get(i).hop();
        // or, alternatively, using foreach syntax:
        for(Gerbil g : gerbils)
            g.hop();
    }
}
