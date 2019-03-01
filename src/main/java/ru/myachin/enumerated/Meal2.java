package ru.myachin.enumerated;

import net.mindview.util.Enums;

/**
 * 4. Повторите {@link Meal предыдущее упражнение} для <tt>Meal2.java</tt>
 */
public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAIN_COURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    SOUP(Food.Soup.class);

    private Food[] values;

    Meal2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (Meal2 meal2 : values()) {
                Food food = meal2.randomSelection();
                System.out.println(food);
            }

            System.out.println("---");
        }
    }
}
