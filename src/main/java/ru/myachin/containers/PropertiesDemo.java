package ru.myachin.containers;

import net.mindview.containers.Maps;
import net.mindview.util.CountingMapData;

import java.util.Map;
import java.util.Properties;

/**
 * 14. Покажите, что {@link Properties} работает в {@link Maps приведенной программе}.
 */
public class PropertiesDemo {

    public static void main(String[] args) {
//        Maps.test(new Properties()); compile error
        test(new Properties());
    }

    public static void test(Map<Object,Object> map) {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new net.mindview.util.CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new net.mindview.util.CountingMapData(25));
        System.out.println(map.keySet());
        // Producing a Collection of the values:
        System.out.print("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"F0\"): "
                + map.containsValue("F0"));
        Object key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        System.out.println(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
    }
}
