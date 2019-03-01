package ru.myachin.enumerated;

import net.mindview.util.Enums;

/**
 * 3. Добавьте новую категорию <tt>Course</tt> в <tt>Course.java</tt> и продемонстрируйте, что она работает в
 * <tt>Meal.java</tt>
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }

            System.out.println("---");
        }
    }
}

interface Food {

    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA
    }

    enum Soup implements Food {
        FISH_SOUP, MUSHROOM_SOUP, KHARCHO, MILK_SOUP
    }
}

enum Course {
    APPETIZER(Food.Appetizer.class),
    MAIN_COURSE(Food.MainCourse.class),
    DESERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    SOUP(Food.Soup.class);

    private Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}