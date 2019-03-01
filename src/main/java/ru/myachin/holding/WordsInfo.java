package ru.myachin.holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 21. Используя контейнер {@link Map}, создайте по образцу <b>UniqueWords.java</b> программу для подсчета вхождений
 * слов в файле. Отсортируйте результаты методом {@link Collections#sort(List, Comparator)} со вторым аргументом
 * {@link String#CASE_INSENSITIVE_ORDER} (для получения алфавитной сортировки) и выведите результат.
 * <p>
 * 22. Измените предыдущее упражнение так, чтобы для хранения слов в нем использовался класс с объектом {@link String}
 * и полем счетчика. Для хранения списка слов должен использоваться контейнер {@link Set}, содержащий такие объекты.
 */
public class WordsInfo {

    public static void main(String[] args) {
        Map<String, Integer> map = wordsCountMap("src\\main\\java\\ru\\myachin\\holding\\WordsInfo.java");
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, String.CASE_INSENSITIVE_ORDER);

        for (String s : keyList) {
            System.out.println(s + ": " + map.get(s));
        }

        System.out.println("\nCounting through object");
        Set<WordCounter> wordCounters =
                new TreeSet<>(wordsCountSet("src\\main\\java\\ru\\myachin\\holding\\WordsInfo.java"));
        for (WordCounter wordCounter : wordCounters) {
            System.out.println(wordCounter.word + ": " + wordCounter.count);
        }
    }

    static Map<String, Integer> wordsCountMap(final String fileName) {
        Map<String, Integer> resultMap = new HashMap<>();
        List<String> words = new TextFile(fileName, "\\W+");
        for (String word : words) {
            resultMap.put(word, resultMap.containsKey(word) ? resultMap.get(word) + 1 : 1);
        }

        return resultMap;
    }

    static Set<WordCounter> wordsCountSet(final String fileName) {
        Set<WordCounter> resultSet = new HashSet<>();
        List<String> words = new TextFile(fileName, "\\W+");
        for (String word : words) {
            WordCounter wordCounter = new WordCounter(word);
            if (resultSet.contains(wordCounter)) {
                incrementWordCount(resultSet.iterator(), wordCounter);
            } else {
                resultSet.add(wordCounter);
            }
        }

        return resultSet;
    }

    private static void incrementWordCount(final Iterator<WordCounter> it, WordCounter wordCounter) {
        while (it.hasNext()) {
            WordCounter next = it.next();
            if (next.equals(wordCounter)) {
                next.count++;
                break;
            }
        }
    }

    private static class WordCounter implements Comparable<WordCounter> {

        private final String word;
        private int count = 1;

        public WordCounter(String word) {
            this.word = word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordCounter that = (WordCounter) o;
            return word.equals(that.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

        @Override
        public int compareTo(WordCounter o) {
            return word.compareToIgnoreCase(o.word);
        }
    }
}
