package com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Practice6;

import com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Enums;

enum Appetizer implements Food {
    SALAD, SOUP, SPRING_ROLLS;
}

enum MainCourse implements Food {
    LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
}

enum Dessert implements Food {
    TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
}

enum Coffee implements Food {
    BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
}

public enum Meal {
    APPETIZER(Appetizer.class), MAINCOURSE(MainCourse.class), DESSERT(Dessert.class), COFFEE(Coffee.class);
    private Food[] values;

    private Meal(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal meal : Meal.values()) {
                Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}

interface Food {
}
