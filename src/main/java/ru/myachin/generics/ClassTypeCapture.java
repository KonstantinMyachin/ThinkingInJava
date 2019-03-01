package ru.myachin.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * 21. Измените пример <tt>ClassTypeCapture.java</tt>, добавьте в него контейнер <tt>Map<String, Class<?>>></tt>,
 * метод <tt>addType(String typename, Class<?>)</tt> и метод <tt>createNew(String typename)</tt>. Метод
 * <tt>createNew()</tt> либо создает новый экземпляр клсса, связанный с аргументом-строкой, либо выводит сообщение
 * об ошибке.
 */
public class ClassTypeCapture {

    private Map<String, Class<?>> map = new HashMap<>();

    void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    Object createNew(String typeName) {
        Exception cause = null;
        if (map.containsKey(typeName)) {
            try {
                return map.get(typeName).newInstance();
            } catch (InstantiationException e) {
                cause = e;
            } catch (IllegalAccessException e) {
                cause = e;
            }
        }

        if (cause != null) {
            throw new RuntimeException(cause);
        } else
            throw new RuntimeException(String.format("Not found class for %s", typeName));
    }

    public Map<String, Class<?>> getMap() {
        return map;
    }
}
