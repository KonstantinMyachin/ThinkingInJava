package ru.myachin.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 11. Напишите метод, который использует {@link Iterator} для перебора {@link Collection} и выводит результат вызова
 * {@link Object#toString()} для каждого объекта в контейнере. Заполните объектами разные типы {@link Collection} и
 * примените свой метод к каждому контейнеру
 */
public class IteratorToString {

    public static void main(String[] args) {
        Collection<String> sCollection = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        Collection<Integer> iCollection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collection<Character> cCollection = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));

        collectionToString(sCollection);
        collectionToString(iCollection);
        collectionToString(cCollection);
    }

    static void collectionToString(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
