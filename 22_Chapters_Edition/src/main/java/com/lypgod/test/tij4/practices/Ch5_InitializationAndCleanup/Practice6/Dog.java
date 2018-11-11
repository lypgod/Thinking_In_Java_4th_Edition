package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice6;

public class Dog {
    private void bark() {System.out.println("quiet");}
    private void bark(char c, byte b) {System.out.println("barking");}
    private void bark(byte b, char c) {System.out.println("howling");}
    public static void main(String[] args) {
        Dog d = new Dog();
        d.bark();
        d.bark('c', (byte)0);
        d.bark((byte)0, 'c');
    }
}
