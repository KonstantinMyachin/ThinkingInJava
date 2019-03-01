package ru.myachin.io;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * 1. Измените программу <tt>DirList.java</tt> (или одну из ее разновидностей) так, чтобы объект
 * {@link java.io.FilenameFilter} открывал и читал каждый файл (с использованием класса {@link TextFile}) и принимал
 * файл на основании того, присутствуют ли в этом файле аргументы комендной строки.
 * <p>
 * 3. Измените программу <tt>DirList.java</tt> (или одну из ее разновидностей) так, чтобы она суммировала размеры
 * выбранных файлов.
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    TextFile file = new TextFile(name, "\\W+");
                    return !file.isEmpty();
                }
            });
        }

        if (list.length > 0) {
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
            System.out.println(Arrays.toString(list));

            long totalSpace = 0;
            for (String fileName : list) {
                totalSpace += new File(path, fileName).length();
            }

            System.out.println(String.format("total space = %d bytes", totalSpace));
        }

    }
}
