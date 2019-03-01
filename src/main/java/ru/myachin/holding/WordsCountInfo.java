package ru.myachin.holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * 25. Создайте контейнер {@code {@link Map<String, ArrayList<Integer>>}}. Используя {@link TextFile}, откройте
 * текстовый файл и прочитайте его по словам (передайте <b>"\\W+"</b> во втором аргументе
 * {@link TextFile#TextFile(String, String)}. Подсчитывайте слова в процессе чтения; для каждого слова в файле сохраните
 * в {@code ArrayList<Integer>} счетчик слов, связанный с этим словом (то есть фактически позицию файла, в которой было
 * обнаружено слово)
 * <p>
 * 26. Возьмите контейнер {@link Map} из предыдущего упражнения и воссоздайте порядок слов в исходном файле.
 */
public class WordsCountInfo {

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        List<String> words = new TextFile("src\\main\\java\\ru\\myachin\\holding\\WordsCountInfo.java", "\\W+");
        ListIterator<String> it = words.listIterator();
        while (it.hasNext()) {
            String word = it.next();
            if (map.containsKey(word)) {
                map.get(word).add(it.previousIndex());
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(it.previousIndex());
                map.put(word, list);
            }
        }

        System.out.println(map);

        Map<Integer, String> sourceFile = new TreeMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            for (Integer index : entry.getValue()) {
                sourceFile.put(index, entry.getKey());
            }
        }

        System.out.println(sourceFile.values());
    }
}