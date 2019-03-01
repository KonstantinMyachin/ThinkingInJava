package ru.myachin.io;

import net.mindview.util.TextFile;

import java.util.Map;
import java.util.TreeMap;

/**
 * 17. Используя {@link TextFile} и {@link Map}, создайте прогармму для подсчета вхождений символов в файл. (Например,
 * если в файле буква <tt>"a"</tt> встречается 12 раз, с эттим символом связывается значение типа {@link Integer},
 * равное 12.)
 */
public class CharCounter {

    public static void main(String[] args) {
        String pomXml = TextFile.read("pom.xml");
        Map<Character, Integer> counter = new TreeMap<>();
        for (char c : pomXml.toCharArray()) {
            counter.put(c, counter.containsKey(c) ? counter.get(c) + 1 : 1);
        }

        System.out.println(counter);
    }
}
