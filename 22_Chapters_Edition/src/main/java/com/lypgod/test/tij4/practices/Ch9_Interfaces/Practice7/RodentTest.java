package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice7;

/**
 * Created by liuyp on 16-10-9.
 */
interface Rodent {
    void eat();
}

class Mouse implements Rodent {
    @Override
    public void eat() {
        System.out.println("Mouse eat.");
    }
}

class Gerbil implements Rodent {
    @Override
    public void eat() {
        System.out.println("Gerbil eat.");
    }
}

class Hamster implements Rodent {
    @Override
    public void eat() {
        System.out.println("Hamster eat.");
    }
}

public class RodentTest {

    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[] {new Mouse(), new Gerbil(), new Hamster()};
        for(Rodent rodent:rodents) {
            rodent.eat();
        }
    }

}
