package ru.myachin.holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Возьмите класс {@link Gerbil Gerbil из упражнения 1} и поместите его в контейнер {@link Map}. Используйте объект
 * {@link String}, содержащий имя каждого объекта {@link Gerbil}, в качестве ключа для связывания с объектом
 * {@link Gerbil} (значение), помещаемым в таблицу. Получите {@link Iterator} для {@link Map#keySet()} и используйте его
 * для перемещения по {@link Map}, с выборкой объекта {@link Gerbil} для каждого ключа, выводом ключа и вызовом метода
 * {@link Gerbil#hop()}.
 */
public class GerbilMap {

    public static void main(String[] args) {
        Map<String, Gerbil> map = new HashMap<>();
        map.put("First Gerbil", new Gerbil(1));
        map.put("Second Gerbil", new Gerbil(2));
        map.put("Third Gerbil", new Gerbil(3));

        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Gerbil gerbil = map.get(key);
            System.out.println(key);
            gerbil.hop();
        }
    }
}
