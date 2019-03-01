package ru.myachin.object;

/**
 * 4. Сделайте то же для кода с использованием класса DataOnly.
 */
public class DataOnly {

    int i;
    double d;
    boolean b;

    public static void main(String[] args) {
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 47;
        dataOnly.d = 1.1;
        dataOnly.b = false;
    }
}