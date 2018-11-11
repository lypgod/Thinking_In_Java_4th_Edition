package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice16;

public class Practice16 {
    static class Integer implements SkipGenerator<java.lang.Integer> {
        private int value = 0;
        private int n;
        Integer(int n) { this.n = n; }
        public java.lang.Integer next() { return value++; }
        public java.lang.Integer next(int n) { return value += n; }
    }
    public static void main(String[] args) {
        Integer integer = new Integer(0);
        for (int i = 0; i < 3; i++) {
            System.out.println(integer.next(3));
        }
    }
}
