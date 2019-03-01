package ru.myachin.holding;

import java.util.*;

/**
 * 19. Повторите {@link MapOrder предыдущее упражнение} c {@link HashSet} и {@link LinkedHashSet}
 */
public class SetOrder {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(10, 7, 12));
        System.out.println("HashSet: " + set);

        Set<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(set);

        Set<Integer> linkedHashSet = new LinkedHashSet<>(sortedSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }
}
