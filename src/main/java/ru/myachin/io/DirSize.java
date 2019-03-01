package ru.myachin.io;

import net.mindview.util.Directory;

import java.io.File;

/**
 * 4. Используйте вызов {@link Directory#walk(File, String)} для суммирования размеров всех файлов в дереве каталого, имена
 * которых соответствуют задарнному регулярному выраженияю.
 */
public class DirSize {

    public static void main(String[] args) {
        Directory.TreeInfo treeInfo =
                Directory.walk(System.getProperty("user.dir"), ".*\\.java");
        long javaSourcesSpace = 0;
        for (File file : treeInfo) {
            javaSourcesSpace += file.length();
        }

        System.out.println(String.format("Size of java sources: %d bytes", javaSourcesSpace));
    }
}
