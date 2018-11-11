package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice3;


class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
