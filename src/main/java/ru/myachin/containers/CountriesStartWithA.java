package ru.myachin.containers;

import net.mindview.util.Countries;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2. Создайте контейнеры {@link Map} и {@link Set} со всеми странами, названия которых начинаются на букву <tt>A</tt>.
 */
public class CountriesStartWithA {

    public static void main(String[] args) {
        final Map<String, String> capitals = Countries.capitals();
        final Set<String> countries = capitals.keySet();
        final Set<String> resultSet = new LinkedHashSet<>();
        final LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        for (String country : countries) {
            if (country.charAt(0) == 'A') {
                resultSet.add(country);
                resultMap.put(country, capitals.get(country));
            }
        }

        System.out.println(resultSet);
        System.out.println(resultMap);
    }
}
