package ru.myachin.holding;

import java.util.*;

/**
 * 24. Заполните карту {@link LinkedHashMap} строковыми ключами и такими же значениями, взятыми по вашему усмотрению.
 * После этого извлеките пары, отсортируйте их по ключам и заново вставьте в карту.
 */
public class LinkedHashMapOrder {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Жулебино", "район");
        map.put("Москва", "город");
        map.put("Россия", "страна");
        map.put("Европа", "континент");
        map.put("Евразия", "материк");

        System.out.println(map);

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        Map<String, String> sortedMap = new LinkedHashMap<>();
        for (String s : list) {
            sortedMap.put(s, map.get(s));
        }

        System.out.println(sortedMap);
    }
}
