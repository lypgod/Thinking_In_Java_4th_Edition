package com.lypgod.test.tij4.practices.Ch15_Generics.Practice28;

class Pet {}
class Cat extends Pet {}

class Generic1<T> {
    void print(T t) {
        System.out.println("Generic1 - " + t);
    }
}
class Generic2<T> {
    T t;
    T get() {
        return t;
    }
}
public class Practice28 {
    <T> void f(Generic1<? super T> generic1, T t) {
        generic1.print(t);
    }
    <T> T g(Generic2<? extends T> generic2) {
        return generic2.get();
    }

    public static void main(String[] args) {
        Practice28 practice28 = new Practice28();
        practice28.f(new Generic1<Pet>(), new Cat());
        practice28.g(new Generic2<Pet>());
    }
}
