package ru.myachin.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 27. Покажите, что ковариантность не работает c {@link List} на примере {@link Number} и {@link Integer}.
 */
public class CovariantContainer {

    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<Integer>();
        // numbers.add(new Integer(1));
        // numbers.add(new Float(1.0));
        // numbers.add(new Object());
        numbers.add(null);
        Number n = numbers.get(0);
        System.out.println(n);
    }
}
