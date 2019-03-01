package ru.myachin.io;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 7. Отскройте текстовый файл для построчного чтения. Считывайте из него строки в объект {@link String}, который затем
 * помещается в {@link LinkedList}. Выведите все строки в обратном порядке средствами класса {@link LinkedList}
 * <p>
 * 8. Измените упражнение 7 так, чтобы имя файла с обрабатываемым текстом передавалось в командной строке.
 * <p>
 * 9. Измените упражнение 8 так, чтобы буквы во всех прочитанных строках преобразовывались к верхнему регистру.
 * Направьте результат в "устройство" стандартного вывода {@link System#out}.
 * <p>
 * 10. Измените упражнение 8 так, чтобы программа получала в дополнительных аргументах командной строки слова, которые
 * нужно найти в файле. Выведите все строки, где были найдены указанные слова.
 * <p>
 * 12. Измените упражнение 8 так, чтобы оно также открывало текстовый файл для записи. Запишите в файл строки из
 * {@link LinkedList} вместе с номерами строк (не пытайтесь использовать классы <tt>LineNumber</tt>
 */
public class ReadFileInformation {

    public static void main(String[] args) {
        int argsCount = args.length;
        if (argsCount < 2) {
            System.out.println("Usage: filePath words (separated by space)");
            System.exit(-1);
        }

        BufferedReader reader = null;
        List<String> lines = new LinkedList<>();
        List<String> wordsToSearch = Arrays.asList(args);
        wordsToSearch = wordsToSearch.subList(1, argsCount);
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String s;
            while ((s = reader.readLine()) != null) {
                for (String toSearch : wordsToSearch) {
                    if (s.toLowerCase().contains(toSearch)) {
                        lines.add(s.toUpperCase());
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (!lines.isEmpty()) {
            PrintWriter writer = null;
            try {
                long lineNumber = 0;
                writer = new PrintWriter("OutPutFile.out");
                ListIterator<String> iterator = lines.listIterator(lines.size());
                while (iterator.hasPrevious()) {
                    String line = iterator.previous();
                    System.out.println(line);
                    writer.println(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }
    }
}
