package ru.myachin.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 12. Измените пример {@link net.mindview.strings.Groups} так, чтобы в нем подсчитывались все уникальные слова, не
 * начинающиеся с прописной буквы.
 */
public class Groups {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b((?![A-Z])\\w+)\\b");
        Set<String> uniqueWords = new HashSet<>();
        Matcher m = p.matcher(net.mindview.strings.Groups.POEM);
        while (m.find()) {
            uniqueWords.add(m.group());
        }

        System.out.println(uniqueWords.size());
        System.out.println(uniqueWords);
    }
}
