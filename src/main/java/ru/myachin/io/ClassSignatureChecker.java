package ru.myachin.io;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;

/**
 * 20. Используя метод {@link Directory#walk(File, String)} и {@link BinaryFile}, проверьте, что все файлы
 * <tt>.class</tt> в дереве каталогов начинаются с шестнадцатеричной последовательности <tt>"CAFEBABE"</tt>.
 */
public class ClassSignatureChecker {

    public static void main(String[] args) throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(".", ".*\\.class");
        for (File file : treeInfo) {
            System.out.println(file.getName());
            System.out.println(isValidClassSignature(BinaryFile.read(file)));
        }
    }

    static boolean isValidClassSignature(byte[] fileBytes) {
        if (fileBytes.length < 4) {
            System.out.println("Incorrect class");
        }


        return fileBytes[0] == (byte) 202
                && fileBytes[1] == (byte) 254
                && fileBytes[2] == (byte)186
                && fileBytes[3] == (byte) 190;
    }
}
