package ru.myachin.containers;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 9. Используйте генератор {@link RandomGenerator.String} для заполнения множества {@link TreeSet} с алфавитной
 * сортировкой. Выведите содержимое {@link TreeSet}, чтобы подтвердить правильность сортировки.
 */
public class RandomStringTreeSet {

    public static void main(String[] args) {
        final String[] strings = Generated.array(String.class, new RandomGenerator.String(), 15);
        final TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(Arrays.asList(strings));
        System.out.println(treeSet);
    }
}
