package ru.myachin.object;

/**
 * 6. Напишите программу, включающую метод storage(), приведенный ранее в этой главе.
 */
public class Storage {

    static final String S = "JAVA";

    public static void main(String[] args) {
        Storage storage = new Storage();
        System.out.println(storage.storage(Storage.S));
    }

    int storage(String s) {
        return s.length() * 2;
    }
}