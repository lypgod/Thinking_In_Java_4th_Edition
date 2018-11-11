package com.lypgod.test.tij4.practices.Ch13_Strings.Practice6;

public class Practice6 {
    int i = 0;
    long l = 0;
    float f = 0.0f;
    double d = 0.0;

    Practice6(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    public String toString() {
        return String.format("i = %d\nl = %d\nf = %.16g\nd = %.16g\n", i, l, f, d);
    }

    public static void main(String[] args) {
        Practice6 x = new Practice6(2, 45L, 1.2f, 2.7182818289);
        Practice6 ex = new Practice6(-2147483648, -9223372036854775808L, 1.1754943508222875E-38f, 2.2250738585072014E-308);
        Practice6 exMax = new Practice6(2147483647, 9223372036854775807L, 3.4028234663852886E38f, 1.7976931348623157E308);
        System.out.println(x);
        System.out.println(ex);
        System.out.println(exMax);
    }
}
