package com.lypgod.test.tij4.practices.Ch15_Generics.Practice21;//: generics/ClassTypeCapture.java

import java.util.Map;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<?> kind;
    Map<String, Class<?>> map;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<?> kind, Map<String, Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Class<?> kind) {
        map.put(typename, kind);
    }

    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        if (map.containsKey(typename))
            return map.get(typename).newInstance();
        System.out.println(typename + " class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
} /* Output:
true
true
false
true
*///:~
