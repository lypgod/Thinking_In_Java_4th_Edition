package com.lypgod.test.tij4.practices.Ch15_Generics.Practice1;//: generics/Holder3.java

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<Individual> h3Cat = new Holder3<Individual>(new Cat());
        Holder3<Individual> h3Cymric = new Holder3<Individual>(new Cymric());
        Holder3<Individual> h3Dog = new Holder3<Individual>(new Dog());
        Holder3<Individual> h3EgyptianMau = new Holder3<Individual>(new EgyptianMau());
        Holder3<Individual> h3Hamster = new Holder3<Individual>(new Hamster());
        Holder3<Individual> h3Individual = new Holder3<Individual>(new Individual());
        Holder3<Individual> h3Manx = new Holder3<Individual>(new Manx());
        Holder3<Individual> h3Mouse = new Holder3<Individual>(new Mouse());
        Holder3<Individual> h3Mutt = new Holder3<Individual>(new Mutt());
        Holder3<Individual> h3Person = new Holder3<Individual>(new Person("you"));
        Holder3<Individual> h3Pet = new Holder3<Individual>(new Pet());
        Holder3<Individual> h3Pug = new Holder3<Individual>(new Pug());
        Holder3<Individual> h3Rat = new Holder3<Individual>(new Rat());
        Holder3<Individual> h3Rodent = new Holder3<Individual>(new Rodent());
    }
} ///:~
