package ru.myachin.containers;

import net.mindview.containers.AssociativeArray;
import net.mindview.util.TextFile;

/**
 * 13. Используйте пример {@link AssociativeArray} для создания счетчика слов, связывающего ключ {@link String} со
 * значением {@link Integer}. Используя средства {@link TextFile}, откройте текстовый файл, разбейте его на слова по
 * пропускам и знакам препинания и подсчитайте вхождения каждого слова в тексте.
 */
public class WordCounterWithAssociativeArray {

    public static void main(String[] args) {
        final String fileName = String.format("src/main/java/%s.java",
                WordCounterWithAssociativeArray.class.getName().replaceAll("\\.", "//"));
        final TextFile file = new TextFile(fileName, "\\W+");
        final AssociativeArray<String, Integer> counter = new AssociativeArray<>(file.size());
        for (String s : file) {
            Integer value = counter.get(s);
            counter.put(s, value == null ? 1 : value + 1);
        }

        System.out.println(counter);
    }
}
