package ru.myachin.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 18. Напишите программу, которая читает файл с исходным кодом Java (имя файла передается в командной строке) и
 * выводит все строковые литералы, содержащиеся в файле.
 */
public class JavaStringExtractor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JavaStringExtractor file");
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("\"(.*?)\"");

        String s = TextFile.read(args[0]);
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}