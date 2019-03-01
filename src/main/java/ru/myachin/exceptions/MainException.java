package ru.myachin.exceptions;

import java.io.FileInputStream;

/**
 * 26. Измените строку имени файла в примере <b>MainException.java</b> так, чтобы она содержала имя несуществующего
 * файла. Запустите программу и обратите внимание на результат.
 */
public class MainException {

    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("TheMainException.java");
        file.close();
    }
}