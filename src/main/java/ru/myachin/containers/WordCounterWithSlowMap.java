package ru.myachin.containers;

import net.mindview.containers.SlowMap;
import net.mindview.util.TextFile;

/**
 * 15. Повторите {@link WordCounterWithAssociativeArray упражнение 13} с использование {@link SlowMap}
 */
public class WordCounterWithSlowMap {

    public static void main(String[] args) {
        final String fileName = String.format("src/main/java/%s.java",
                WordCounterWithSlowMap.class.getName().replaceAll("\\.", "//"));
        final TextFile file = new TextFile(fileName, "\\W+");
        final SlowMap<String, Integer> counter = new SlowMap<>();
        for (String s : file) {
            Integer value = counter.get(s);
            counter.put(s, value == null ? 1 : value + 1);
        }

        System.out.println(counter);
    }
}
