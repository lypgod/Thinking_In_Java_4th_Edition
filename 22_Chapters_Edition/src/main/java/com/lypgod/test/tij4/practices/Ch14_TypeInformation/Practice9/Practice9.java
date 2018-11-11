package com.lypgod.test.tij4.practices.Ch14_TypeInformation.Practice9;

class A {
    int i;
    String s;
}

class B extends A {
    int j;
    float f;
}

class C extends B {
    int k;
    B b;
}

public class Practice9 {
    public static void Hierarchy(Object o) {
        Object[] fields = o.getClass().getDeclaredFields();
        if (fields.length == 0)
            System.out.println(o.getClass() + " has no fields");
        if (fields.length > 0) {
            System.out.println("Field(s) of " + o.getClass() + ":");
            for (Object obj : fields)
                System.out.println(" " + obj);
        }
        if (o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass() + " is a subclass of " +
                    o.getClass().getSuperclass());
            try {
                Hierarchy(o.getClass().getSuperclass().newInstance());
            } catch (InstantiationException e) {
                System.out.println("Unabloe to instantiate obj");
            } catch (IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }
    }

    public static void main(String[] args) {
        Hierarchy(new C());
    }
}
