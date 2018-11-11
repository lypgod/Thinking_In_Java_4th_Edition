package com.lypgod.test.tij4.practices.Ch4_ControllingExecution.Practice10;

import org.junit.Test;

public class VampireNumberTest {
    static int[] getNumbers(int tester) {
        int origin = tester;
        int[] result = new int[String.valueOf(origin).length()];
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = origin % 10;
            origin /= 10;
        }
        return result;
    }

    static void isVampire(int tester) {
        int[] digits = getNumbers(tester);
        if (digits.length == 4) {
            if ((digits[0]*10 + digits[1]) * (digits[2]*10 + digits[3]) == tester) {
                System.out.println((digits[0]*10 + digits[1]) + " * " + (digits[2]*10 + digits[3]) + " = " + tester);
                return;
            }
            if ((digits[0]*10 + digits[1]) * (digits[3]*10 + digits[2]) == tester) {
                System.out.println((digits[0]*10 + digits[1]) + " * " + (digits[3]*10 + digits[2]) + " = " + tester);
                return;
            }
            if ((digits[0]*10 + digits[2]) * (digits[1]*10 + digits[3]) == tester) {
                System.out.println((digits[0]*10 + digits[2]) + " * " + (digits[1]*10 + digits[3]) + " = " + tester);
                return;
            }
            if ((digits[0]*10 + digits[2]) * (digits[3]*10 + digits[1]) == tester) {
                System.out.println((digits[0]*10 + digits[2]) + " * " + (digits[3]*10 + digits[1]) + " = " + tester);
                return;
            }
            if ((digits[0]*10 + digits[3]) * (digits[1]*10 + digits[2]) == tester) {
                System.out.println((digits[0]*10 + digits[3]) + " * " + (digits[1]*10 + digits[2]) + " = " + tester);
                return;
            }
            if ((digits[0]*10 + digits[3]) * (digits[2]*10 + digits[1]) == tester) {
                System.out.println((digits[0]*10 + digits[3]) + " * " + (digits[2]*10 + digits[1]) + " = " + tester);
                return;
            }

            if ((digits[1]*10 + digits[0]) * (digits[2]*10 + digits[3]) == tester) {
                System.out.println((digits[1]*10 + digits[0]) + " * " + (digits[2]*10 + digits[3]) + " = " + tester);
                return;
            }
            if ((digits[1]*10 + digits[0]) * (digits[3]*10 + digits[2]) == tester) {
                System.out.println((digits[1]*10 + digits[0]) + " * " + (digits[3]*10 + digits[2]) + " = " + tester);
                return;
            }
            if ((digits[1]*10 + digits[2]) * (digits[0]*10 + digits[3]) == tester) {
                System.out.println((digits[1]*10 + digits[2]) + " * " + (digits[0]*10 + digits[3]) + " = " + tester);
                return;
            }
            if ((digits[1]*10 + digits[2]) * (digits[3]*10 + digits[0]) == tester) {
                System.out.println((digits[1]*10 + digits[2]) + " * " + (digits[3]*10 + digits[0]) + " = " + tester);
                return;
            }
            if ((digits[1]*10 + digits[3]) * (digits[0]*10 + digits[2]) == tester) {
                System.out.println((digits[1]*10 + digits[3]) + " * " + (digits[0]*10 + digits[2]) + " = " + tester);
                return;
            }
            if ((digits[1]*10 + digits[3]) * (digits[2]*10 + digits[0]) == tester) {
                System.out.println((digits[1]*10 + digits[3]) + " * " + (digits[2]*10 + digits[0]) + " = " + tester);
                return;
            }

            if ((digits[2]*10 + digits[0]) * (digits[1]*10 + digits[3]) == tester) {
                System.out.println((digits[2]*10 + digits[0]) + " * " + (digits[1]*10 + digits[3]) + " = " + tester);
                return;
            }
            if ((digits[2]*10 + digits[0]) * (digits[3]*10 + digits[1]) == tester) {
                System.out.println((digits[2]*10 + digits[0]) + " * " + (digits[3]*10 + digits[1]) + " = " + tester);
                return;
            }
            if ((digits[2]*10 + digits[1]) * (digits[0]*10 + digits[3]) == tester) {
                System.out.println((digits[2]*10 + digits[1]) + " * " + (digits[0]*10 + digits[3]) + " = " + tester);
                return;
            }
            if ((digits[2]*10 + digits[1]) * (digits[3]*10 + digits[0]) == tester) {
                System.out.println((digits[2]*10 + digits[1]) + " * " + (digits[3]*10 + digits[0]) + " = " + tester);
                return;
            }
            if ((digits[2]*10 + digits[3]) * (digits[0]*10 + digits[1]) == tester) {
                System.out.println((digits[2]*10 + digits[3]) + " * " + (digits[0]*10 + digits[1]) + " = " + tester);
                return;
            }
            if ((digits[2]*10 + digits[3]) * (digits[1]*10 + digits[0]) == tester) {
                System.out.println((digits[2]*10 + digits[3]) + " * " + (digits[1]*10 + digits[0]) + " = " + tester);
                return;
            }

            if ((digits[3]*10 + digits[0]) * (digits[1]*10 + digits[2]) == tester) {
                System.out.println((digits[3]*10 + digits[0]) + " * " + (digits[1]*10 + digits[2]) + " = " + tester);
                return;
            }
            if ((digits[3]*10 + digits[0]) * (digits[2]*10 + digits[1]) == tester) {
                System.out.println((digits[3]*10 + digits[0]) + " * " + (digits[2]*10 + digits[1]) + " = " + tester);
                return;
            }
            if ((digits[3]*10 + digits[1]) * (digits[0]*10 + digits[2]) == tester) {
                System.out.println((digits[3]*10 + digits[1]) + " * " + (digits[0]*10 + digits[2]) + " = " + tester);
                return;
            }
            if ((digits[3]*10 + digits[1]) * (digits[2]*10 + digits[0]) == tester) {
                System.out.println((digits[3]*10 + digits[1]) + " * " + (digits[2]*10 + digits[0]) + " = " + tester);
                return;
            }
            if ((digits[3]*10 + digits[2]) * (digits[0]*10 + digits[1]) == tester) {
                System.out.println((digits[3]*10 + digits[2]) + " * " + (digits[0]*10 + digits[1]) + " = " + tester);
                return;
            }
            if ((digits[3]*10 + digits[2]) * (digits[1]*10 + digits[0]) == tester) {
                System.out.println((digits[3]*10 + digits[2]) + " * " + (digits[1]*10 + digits[0]) + " = " + tester);
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1000; i < 9999; i++) {
            isVampire(i);
        }
    }

    @Test
    public void testIsVampire() {
        isVampire(2187);
        isVampire(1260);
        isVampire(1827);
    }
    @Test
    public void testNumberBreak() {
        int[] result = getNumbers(54321);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
