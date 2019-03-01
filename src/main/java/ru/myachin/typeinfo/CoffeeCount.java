package ru.myachin.typeinfo;

import net.mindview.generics.coffee.Coffee;
import net.mindview.generics.coffee.CoffeeGenerator;
import net.mindview.util.TypeCounter;

/**
 * 12. Используйте {@link TypeCounter} с классом {@link CoffeeGenerator} из главы 15.
 */
public class CoffeeCount {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        final CoffeeGenerator coffeeGenerator = new CoffeeGenerator(20);
        for (Coffee coffee : coffeeGenerator) {
            System.out.println(coffee);
            counter.count(coffee);
        }
    }
}