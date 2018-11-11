package com.lypgod.test.tij4.practices.Ch2_Object.Practice11;

class AllTheColorsOfTheRainbow {
    int anIntegerRepresentingColors = 0;
    int hue = 0;
    void changeTheHueOfTheColor(int newHue) {
        hue = newHue;
    }
    int changeColor(int newColor) {
        return anIntegerRepresentingColors = newColor;
    }
}

public class AllTheColorsOfTheRainbowTest {
    public static void main(String[] args) {
        AllTheColorsOfTheRainbow atc = new AllTheColorsOfTheRainbow();
        System.out.println("atc.anIntegerRepresentingColors = " + atc.anIntegerRepresentingColors);
        atc.changeColor(7);
        atc.changeTheHueOfTheColor(77);
        System.out.println("After color change, atc.anIntegerRepresentingColors = " + atc.anIntegerRepresentingColors);
        System.out.println("atc.hue = " + atc.hue);
    }
}
