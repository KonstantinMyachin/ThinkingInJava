package ru.myachin.containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * 3. Используя данные {@link Countries}, несколько раз заполните контейнер {@link Set} одними данными и убедитесь в
 * в том, что {@link Set} в конечном итоге каждый экземпляр входит в множество однократно. Попробуйте сделать то же
 * самое с {@link HashSet}, {@link LinkedHashSet} и {@link TreeSet}.
 */
public class VerifySet {

    public static void main(String[] args) {
        final List<String> names = Countries.names(10);
        Set<String> namesSet = new HashSet<>(names);
        namesSet.addAll(names);
        namesSet.addAll(names);
        System.out.println(namesSet);

        namesSet = new LinkedHashSet<>(names);
        namesSet.addAll(names);
        System.out.println(namesSet);

        namesSet = new TreeSet<>(namesSet);
        System.out.println(namesSet);
    }
}
