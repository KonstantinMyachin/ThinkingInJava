package ru.myachin.io;

import java.io.*;

/**
 * 13. Измените пример <tt>BasicFileOutput.java</tt>, чтобы в нем использовался объект {@link LineNumberReader} для
 * подсчета строк. Обратите внимание, насколько проще подсчитывать строки самостоятельно.
 */
public class CountLines {

    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {

        LineNumberReader in = new LineNumberReader(new FileReader("pom.xml"));
        PrintWriter out = new PrintWriter(file);
        String s;
        while ((s = in.readLine()) != null) {
            out.println(String.format("%d: %s", in.getLineNumber(), s));
        }
        in.close();
        out.close();
    }
}
