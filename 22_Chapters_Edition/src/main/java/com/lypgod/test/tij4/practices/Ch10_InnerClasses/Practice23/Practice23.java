package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice23;

interface U {
    void u1();
    void u2();
    void u3();
}
class A {
    U getU() {
        return new U() {
            @Override
            public void u1() {
                System.out.println("u1()");
            }

            @Override
            public void u2() {
                System.out.println("u2()");
            }

            @Override
            public void u3() {
                System.out.println("u3()");
            }
        };
    }
}
class B {
    private static U[] us = new U[3];
    void add(U u, int index) {
        us[index] = u;
    }
    void remove(int index) {
        us[index] = null;
    }
    void test() {
        for (int i = 0; i < us.length; i++) {
            us[i].u1();
            us[i].u2();
            us[i].u3();
        }
//        for (U u : us) {
//            u.u1();
//            u.u2();
//            u.u3();
//        }
    }
}
public class Practice23 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        B b = new B();
        b.add(a1.getU(), 0);
        b.add(a2.getU(), 1);
        b.add(a3.getU(), 2);
        b.test();
        b.remove(2);
        b.test();
    }
}
