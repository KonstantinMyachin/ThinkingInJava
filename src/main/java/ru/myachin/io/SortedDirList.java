package ru.myachin.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * 2. Создайте класс с именем <tt>SortedDirList</tt>, конструктор которого принимает информацию о пути к файлу и на
 * основании этой информации составляет отсортированный список файлов в каталоге. Создайте два перегруженных метода
 * <tt>list()</tt>, один должен возвращать весь список файлов, другой - подмножество списка, соответствующее аргументу
 * (регулярное выражение).
 */
public class SortedDirList {

    private final File path;

    public SortedDirList(String path) {
        this.path = new File(path);
    }

    public String[] list() {
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public String[] list(final String regEx) {
        String[] list = path.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(regEx);
            }
        });

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(".");
        System.out.println(Arrays.toString(sortedDirList.list(".*.iml")));
    }
}
