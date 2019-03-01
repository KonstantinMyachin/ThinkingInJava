package ru.myachin.containers;

import net.mindview.containers.SimpleHashMap;
import net.mindview.util.TextFile;

/**
 * 19. Повторите {@link WordCounterWithAssociativeArray упражнение 13} для {@link SimpleHashMap}
 */
public class WordCounterWithSimpleHashMap {

    public static void main(String[] args) {
        final String fileName = String.format("src/main/java/%s.java",
                WordCounterWithSimpleHashMap.class.getName().replaceAll("\\.", "//"));
        final TextFile file = new TextFile(fileName, "\\W+");
        final SimpleHashMap<String, Integer> counter = new SimpleHashMap<>();
        for (String s : file) {
            Integer value = counter.get(s);
            counter.put(s, value == null ? 1 : value + 1);
        }

        System.out.println(counter);
    }
}
