package ru.myachin.containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 12. Используйте карты {@link HashMap}, {@link TreeMap} и {@link LinkedHashMap} в методе
 * {@link net.mindview.containers.AssociativeArray#main(String[])}
 */
public class MapsDemo {

    public static void main(String[] args) {
        fillAndPrintMap(new HashMap<>());
        fillAndPrintMap(new TreeMap<>());
        fillAndPrintMap(new LinkedHashMap<>());
    }

    private static void fillAndPrintMap(Map<String, String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tail");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }

        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}
