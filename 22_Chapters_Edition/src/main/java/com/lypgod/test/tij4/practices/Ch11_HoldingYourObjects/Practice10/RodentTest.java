package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyp on 16-10-9.
 */
class Rodent {
    void eat() {
        System.out.println("Rodent eat.");
    }
}

class Mouse extends Rodent {
    @Override
    void eat() {
        System.out.println("Mouse eat.");
    }
}

class Gerbil extends Rodent {
    @Override
    void eat() {
        System.out.println("Gerbil eat.");
    }
}

class Hamster extends Rodent {
    @Override
    void eat() {
        System.out.println("Hamster eat.");
    }
}

public class RodentTest {

    public static void main(String[] args) {
        List<Rodent> rodentList = new ArrayList<>();
        Rodent[] rodents = new Rodent[] {new Rodent(), new Mouse(), new Gerbil(), new Hamster()};
        rodentList.addAll(Arrays.asList(rodents));
        for(Rodent rodent:rodentList) {
            rodent.eat();
        }
    }

}
