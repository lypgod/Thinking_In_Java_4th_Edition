package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice1;

/**
 * Created by liuyp on 16-10-9.
 */
abstract class Rodent {
    abstract void eat();
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
        Rodent[] rodents = new Rodent[] {new Mouse(), new Gerbil(), new Hamster()};
        for(Rodent rodent:rodents) {
            rodent.eat();
        }
    }

}
