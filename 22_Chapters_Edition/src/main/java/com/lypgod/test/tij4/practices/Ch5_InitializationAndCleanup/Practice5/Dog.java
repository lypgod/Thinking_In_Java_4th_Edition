package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice5;

public class Dog {
    private void bark() {System.out.println("quiet");}
    private void bark(char c) {System.out.println("barking " + c);}
    private void bark(byte b) {System.out.println("howling " + b);}
    public static void main(String[] args) {
        Dog d = new Dog();
        d.bark();
        d.bark('c');
        d.bark((byte)0);
    }
}
