package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice14;

import java.util.Random;

/**
 * Created by liuyp on 16-10-9.
 */
class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }

    public String toString() {
        return "Shared " + id;
    }

    public void showRefcount() {
        System.out.println("refcount = " + refcount);
    }
}

class Rodent {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    Rodent(Shared shared) {
        System.out.println("Rodent(Shared) " + id);
        this.shared = shared;
        this.shared.addRef();
    }

    void eat() {
        System.out.println("Rodent eat.");
    }
}

class Mouse extends Rodent {
    Mouse(Shared shared) {
        super(shared);
        System.out.println("Mouse(Shared)");
    }

    @Override
    void eat() {
        System.out.println("Mouse eat.");
    }
}

class Gerbil extends Rodent {
    Gerbil(Shared shared) {
        super(shared);
        System.out.println("Gerbil(Shared)");
    }

    @Override
    void eat() {
        System.out.println("Gerbil eat.");
    }
}

class Hamster extends Rodent {
    Hamster(Shared shared) {
        super(shared);
        System.out.println("Hamster(Shared)");
    }

    @Override
    void eat() {
        System.out.println("Hamster eat.");
    }
}

class RodentGenerator {
    // same shared object to be passed to every Rodent:
    protected Shared shared = new Shared();
    private Random rand = new Random();

    public Rodent next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Mouse(shared);
            case 1:
                return new Gerbil(shared);
            case 2:
                return new Hamster(shared);
        }
    }
}

public class RodentTest {
    static RodentGenerator rodentGenerator = new RodentGenerator();

    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[5];
        for (Rodent rodent : rodents) {
            rodent = rodentGenerator.next();
        }
        rodentGenerator.shared.showRefcount();
    }

}
