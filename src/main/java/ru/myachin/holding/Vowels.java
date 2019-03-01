package ru.myachin.holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 16. Создайте контейнер {@link Set} со всеми гласными буквами. Взяв за основу пример <b>UniqueWords.java</b>,
 * подсчитайте и выведите количество гласных в каждом входном слове, а также выведите общее количество гласных во
 * входном файле.
 * <p>
 * 20. Измените упражнение 16 так, чтобы в контейнере хранилось количество вхождений каждой гласной.
 */
public class Vowels {

    private static final Set<Character> VOWELS = new HashSet<>(
            Arrays.asList('а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е',
                    'А', 'У', 'О', 'Ы', 'И', 'Э', 'Я', 'Ю', 'Ё', 'Е'));

    public static void main(String[] args) {
        System.out.println(vowelsInWord("Мамуля"));
        System.out.println(vowelsInWord("Папа"));

        System.out.println(vowelsInFile("src\\main\\java\\ru\\myachin\\holding\\Vowels.java"));
        System.out.println(vowelsCountMap("Статистика по количеству гласных букв"));
        System.out.println(vowelsCountMapFromFile("src\\main\\java\\ru\\myachin\\holding\\Vowels.java"));
    }

    static int vowelsInWord(final String word) {
        int counter = 0;
        for (int i = 0, n = word.length(); i < n; i++) {
            if (VOWELS.contains(word.charAt(i))) {
                counter++;
            }
        }

        return counter;
    }

    static int vowelsInFile(final String fileName) {
        int counter = 0;
        for (String lines : new TextFile(fileName)) {
            counter += vowelsInWord(lines);
        }

        return counter;
    }

    static Map<Character, Integer> vowelsCountMap(final String word) {
        Map<Character, Integer> resultMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (VOWELS.contains(c)) {
                resultMap.put(c, resultMap.containsKey(c) ? resultMap.get(c) + 1 : 1);
            }
        }

        return resultMap;
    }

    static Map<Character, Integer> vowelsCountMapFromFile(final String fileName) {
        Map<Character, Integer> resultMap = new HashMap<>();
        for (String line : new TextFile(fileName)) {
            Map<Character, Integer> vowelsMapFromLine = vowelsCountMap(line);
            for (Map.Entry<Character, Integer> entry : vowelsMapFromLine.entrySet()) {
                Character key = entry.getKey();
                int count = entry.getValue();
                resultMap.put(key, resultMap.containsKey(key) ? resultMap.get(key) + count : count);
            }
        }

        return resultMap;
    }
}