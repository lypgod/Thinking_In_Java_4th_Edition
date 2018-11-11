package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice14;//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {
    }

    public void destroy() {
    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace() {
    }

    public void destroy() {
    }

    public void kill() {
    }

    public void drinkBlood() {
    }
}

public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    static DangerousMonster getDangerousMonster() {
        return new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("DangerousMonster destroy.");
            }

            @Override
            public void menace() {
                System.out.println("DangerousMonster menace.");
            }
        };
    }

    static Vampire getVampire() {
        return new Vampire() {
            @Override
            public void drinkBlood() {
                System.out.println("Vampire menace.");
            }

            @Override
            public void destroy() {
                System.out.println("Vampire destroy.");
            }

            @Override
            public void kill() {
                System.out.println("Vampire kill.");
            }

            @Override
            public void menace() {
                System.out.println("Vampire menace.");
            }
        };
    }

    public static void main(String[] args) {
        u(getDangerousMonster());
        v(getDangerousMonster());
        u(getVampire());
        v(getVampire());
        w(getVampire());
    }
} ///:~
