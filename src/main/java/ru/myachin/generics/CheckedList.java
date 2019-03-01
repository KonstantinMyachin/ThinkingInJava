package ru.myachin.generics;

import net.mindview.generics.coffee.Cappuccino;
import net.mindview.generics.coffee.Coffee;
import net.mindview.generics.coffee.Latte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 35. Измените пример <tt>CheckedList.java</tt> так, чтобы в нем использовались классы {@link Coffee}, определенные
 * в этой главе.
 */
public class CheckedList {

    static void oldStyleMethod(List probablyLattes) {
        probablyLattes.add(new Cappuccino());
    }

    public static void main(String[] args) {
        List<Latte> lattes = new ArrayList<>();
        oldStyleMethod(lattes);
        lattes = Collections.checkedList(new ArrayList<>(), Latte.class);
        try {
            oldStyleMethod(lattes);
        } catch (Exception e) {
            System.out.println(e);
        }

        final List<Coffee> coffees = Collections.checkedList(new ArrayList<>(), Coffee.class);
        coffees.add(new Latte());
        coffees.add(new Cappuccino());
    }
}
