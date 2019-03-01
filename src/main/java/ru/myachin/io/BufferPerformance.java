package ru.myachin.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * 14. На базе кода <tt>BasicFileOut.java</tt> напишите прогармму для сравнения производительности записи в файл при
 * использовании буферизованного и небуферизованного ввода-вывода.
 */
public class BufferPerformance {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Some", "Strings", "in", "list");
        PrintWriter out = null;
        try {
            out = new PrintWriter("BufferPerformance.out");
            long start = System.currentTimeMillis();
            for (String s : strings) {
                for (int i = 0; i < 500; i++) {
                    out.println(s);
                }
            }
            out.close();
            long end = System.currentTimeMillis();
            System.out.println("BufferedWriteTime = " + (end - start));

            out = new PrintWriter(new FileWriter("BufferPerformance.out"));
            start = System.currentTimeMillis();
            for (String s : strings) {
                for (int i = 0; i < 500; i++) {
                    out.println(s);
                }
            }
            end = System.currentTimeMillis();
            System.out.println("UnbufferedWriteTime = " + (end - start));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
