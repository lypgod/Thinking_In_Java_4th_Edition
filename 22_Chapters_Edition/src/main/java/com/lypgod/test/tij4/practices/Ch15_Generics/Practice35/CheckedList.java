package com.lypgod.test.tij4.practices.Ch15_Generics.Practice35;//: generics/CheckedList.java
// Using Collection.checkedList().

import java.util.*;

class Pet {
}

class Cat extends Pet {
}

class Dog extends Pet {
}

public class CheckedList {
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Integer(3));
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println(e);
        }
        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
} /* Output:
java.lang.ClassCastException: Attempt to insert class typeinfo.pets.Cat element into collection with element type class typeinfo.pets.Dog
*///:~
