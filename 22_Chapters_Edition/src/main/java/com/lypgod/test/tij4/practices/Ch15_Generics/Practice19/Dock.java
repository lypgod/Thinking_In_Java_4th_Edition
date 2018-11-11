package com.lypgod.test.tij4.practices.Ch15_Generics.Practice19;

import java.util.ArrayList;
import java.util.Random;

class Cargo {
    private int cargoNumber;

    private Cargo(int cargoNumber) {
        this.cargoNumber = cargoNumber;
    }

    @Override
    public String toString() {
        return "Cargo #" + cargoNumber;
    }

    public static Generator<Cargo> generator = new Generator<Cargo>() {
        @Override
        public Cargo next() {
            return new Cargo(new Random().nextInt(1000));
        }
    };
}

class Container extends ArrayList<Cargo> {
    Container(int cargos) {
        Generators.fill(this, Cargo.generator, cargos);
    }

    @Override
    public String toString() {
        String result = "";
        for (Cargo c : this) {
            result += "      " + c + "\n";
        }
        return result;
    }
}

class Ship extends ArrayList<Container> {
    Ship(int containers, int cargos) {
        for (int i = 0; i < containers; i++) {
            add(new Container(cargos));
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Container c : this) {
            result += "    Container " + "\n" + c;
        }
        return result;
    }
}

public class Dock extends ArrayList<Ship> {
    Dock(int ships, int containers, int cargos) {
        for (int i = 0; i < ships; i++) {
            add(new Ship(containers, cargos));
        }
    }

    @Override
    public String toString() {
        String result = "Dock\n";
        for (Ship c : this) {
            result += "  Ship " + "\n" + c;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Dock(4, 3, 2));
    }
}
