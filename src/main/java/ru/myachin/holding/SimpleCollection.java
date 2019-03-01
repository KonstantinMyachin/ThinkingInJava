package ru.myachin.holding;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 2. Измените пример <b>SimpleCollection.java</b>, чтобы в качестве контейнера использовалось подмножество {@link Set}
 */
public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }

        for (Integer i : c) {
            System.out.print(i + ", ");
        }
    }
}