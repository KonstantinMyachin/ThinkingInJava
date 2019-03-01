package ru.myachin.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 19. На основе двух последних упражнений напишите программу, которая анализирует исходный код Java и выдает список
 * всех имен классов, использованных в программе.
 */
public class JavaClassUsageExtractor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Solution file");
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("(import\\s+.*)|(class\\s+\\w+)");

        String s = TextFile.read(args[0]);
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            System.out.println(m.group().replaceAll("import|class|;", ""));
        }
    }
}