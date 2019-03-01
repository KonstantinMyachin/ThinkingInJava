package ru.myachin.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 17. Напишите программу, которая читает файл с исходным кодом Java (имя файла передается в командной строке) и
 * выводит все строковые литералы, содержащиеся в файле.
 */
public class JavaCommentExtractor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JavaCommentExtractor file");
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("/\\*" + //Match START OF THE COMMENT
                        "(.*?)" +                          //Match all chars
                        "\\*/" +                           //Match END OF THE COMMENT
                        "| //(.*?)$",                      //Match C++ style comments
                Pattern.COMMENTS | Pattern.MULTILINE | Pattern.DOTALL);

        String s = TextFile.read(args[0]);
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}