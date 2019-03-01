package ru.myachin.strings;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 15. Измените пример {@link net.mindview.strings.JGrep} так, чтобы в его аргументах могли передаваться флаги
 * (например, {@link Pattern#CASE_INSENSITIVE}, {@link Pattern#MULTILINE}.
 * <p>
 * 16. Измените пример {@link net.mindview.strings.JGrep}, чтобы в аргументе ему можно было передать имя каталога
 * или файла (при передачи каталога в поиск должны включиться все файлы, находящиеся в указанном каталоге). Подсказка:
 * список имен файлов можно построить <code>File[] files = new File(".").listFiles()</code>.
 */
public class JGrep2 {

    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("UNIX_LINES", Pattern.UNIX_LINES);
        map.put("CASE_INSENSITIVE", Pattern.CASE_INSENSITIVE);
        map.put("COMMENTS", Pattern.COMMENTS);
        map.put("MULTILINE", Pattern.MULTILINE);
        map.put("LITERAL", Pattern.LITERAL);
        map.put("DOTALL", Pattern.DOTALL);
        map.put("UNICODE_CASE", Pattern.UNICODE_CASE);
        map.put("CANON_EQ", Pattern.CANON_EQ);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java JGrep2 file regex regex_pattern");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1], map.get(args[2]));
        File file = new File(args[0]);
        File[] files = file.isDirectory() ? file.listFiles() : new File[]{file};
        for (File sourceFile : files) {
            System.out.println(sourceFile.getName());
            int index = 0;
            Matcher m = p.matcher("");
            for (String line : new TextFile(sourceFile.getAbsolutePath())) {
                m.reset(line);
                while (m.find()) {
                    System.out.println(index++ + ": " + m.group() + ": " + m.start());
                }
            }
        }
    }
}