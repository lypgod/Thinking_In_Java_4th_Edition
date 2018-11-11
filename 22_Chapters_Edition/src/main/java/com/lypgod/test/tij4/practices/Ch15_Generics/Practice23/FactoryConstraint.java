package com.lypgod.test.tij4.practices.Ch15_Generics.Practice23;//: generics/FactoryConstraint.java

interface FactoryI<T> {
    T create(T t);
}

class Foo2<T> {

    public <F extends FactoryI<T>> Foo2(F factory, T t) {
        System.out.println(factory.create(t));
    }
    // ...
}

class IntegerFactory implements FactoryI<Integer> {
    public Integer create(Integer i) {
        return i;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create(Widget widget) {
            return widget;
        }
    }

    @Override
    public String toString() {
        return "Widget";
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory(), 3);
        new Foo2<>(new Widget.Factory(), new Widget());
    }
} ///:~
