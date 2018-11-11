package com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Practice3;

import com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Enums;

enum Course3 {
    APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), SECONDCOURSE(Food.SecondCourse.class),
    DESSERT(Food.Dessert.class), COFFEE(Food.Coffee.class);
    private Food[] values;

    private Course3(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}

interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }

    enum SecondCourse implements Food {
        LEG_OF_LAMB, NEW_YORK_STEAK, MAINE_LOBSTER, ALASKAN_KING_CRAB;
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}

public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course3 course : Course3.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
