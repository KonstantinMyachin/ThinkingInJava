package ru.myachin.strings;

/**
 * 6. Создайте класс с полями <tt>int, long, float и double</tt>. Создайте для этого класса метод {@link #toString()},
 * использующий {@link String#format(String, Object...)}, и продемонстрируйте, что ваш класс работает правильно.
 */
public class DataHolder {

    private int i = 1;
    private long l = 2L;
    private float f = 3.6f;
    private double d = 3.7;

    public static void main(String[] args) {
        System.out.println(new DataHolder());
    }

    @Override
    public String toString() {
        return String.format("DataHolder holds fields:%n int = %d%n long = %d%n float = %f%n double = %e",
                i, l, f, d);
    }
}