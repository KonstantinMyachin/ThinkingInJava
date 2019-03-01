package ru.myachin.strings;

import java.util.Scanner;

/**
 * 20. Создайте класс, содержащий поля типов <tt>int, long, float, double и String</tt>. Создайте для этого класса
 * конструктор, который получает один аргумент String, сканирует полученную строку и разбирает ее по разным полям.
 * Добавье метод {@link #toString()} и продемонстрируйте правильность работы своего класса.
 */
public class MyScanner {
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;

    MyScanner(String s) {
        Scanner scanner = new Scanner(s);
        if (scanner.hasNextLine()) {
            this.s = scanner.nextLine();
        }

        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
        }

        if (scanner.hasNextLong()) {
            l = scanner.nextLong();
        }

        if (scanner.hasNextFloat()) {
            f = scanner.nextFloat();
        }

        if (scanner.hasNextDouble()) {
            d = scanner.nextDouble();
        }
    }

    public static void main(String[] args) {
        MyScanner s = new MyScanner("Sir Robin of Camelot\n22 1 1,61803 1,53434");
        System.out.println(s);
    }

    @Override
    public String toString() {
        return String.format("String = '%s' int = %d long = %d float = %f double = %f", s, i, l, f, d);
    }
}