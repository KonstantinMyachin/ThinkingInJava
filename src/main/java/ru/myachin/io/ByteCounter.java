package ru.myachin.io;

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 19. Используя классы {@link BinaryFile} и {@link Map}, создайте программу для подсчета вхождений разных байтов в
 * файле.
 */
public class ByteCounter {

    public static void main(String[] args) throws IOException {
        byte[] bytes = BinaryFile.read("pom.xml");
        Map<Byte, Integer> counter = new TreeMap<>();
        for (byte aByte : bytes) {
            counter.put(aByte, counter.containsKey(aByte) ? counter.get(aByte) + 1 : 1);
        }

        System.out.println(counter);
    }
}
