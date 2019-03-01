package ru.myachin.holding;

import java.util.*;

/**
 * 18. Заполните контейнер {@link HashMap} парами "ключ-значение". Выведите результаты, чтобы продемонстрировать
 * упорядочение по хеш-коду. Извлеките пары, отсортируйте по ключу и поместите результат в {@link LinkedHashMap}.
 * Покажите, что элементы хранятся в порядке вставки.
 */
public class MapOrder {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "Ten");
        map.put(7, "Seven");
        map.put(12, "Twelve");

        System.out.println("HashMap: " + map);
        Set<Integer> keySet = map.keySet();
        Set<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(keySet);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (Integer i : sortedSet) {
            linkedHashMap.put(i, map.get(i));
        }

        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
}