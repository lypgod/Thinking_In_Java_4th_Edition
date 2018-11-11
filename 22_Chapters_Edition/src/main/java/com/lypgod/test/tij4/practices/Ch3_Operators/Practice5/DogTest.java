package com.lypgod.test.tij4.practices.Ch3_Operators.Practice5;

class Dog {
    String name;
    String says;

    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    @Override
    public String toString() {
        return "Dog " + name + " says \"" + says + "\"";
    }
}

public class DogTest {

    public static void main(String[] args) {
        Dog dog1 = new Dog("spot", "Ruff!");
        Dog dog2 = new Dog("scruffy", "Wulf!");
        System.out.println(dog1);
        System.out.println(dog2);
    }
}
