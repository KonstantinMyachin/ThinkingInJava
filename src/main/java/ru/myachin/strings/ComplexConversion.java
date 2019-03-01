package ru.myachin.strings;

import java.util.Formatter;

/**
 * 5. Для каждого базового типа преобразования в приведенной таблице напишите самое сложное из возможных выражений
 * форматирования. Другими словами, используйте все возможные форматные спецификаторы, доступные для этого типа
 * преобразования.
 */
public class ComplexConversion {

    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        f.format("%-15d%n", 15);
        f.format("%15c%n", 'c');
        f.format("%-15.10b%n", true);
        f.format("%15.10s%n", "This is a string");
        f.format("%-15.3f%n", 3.14234);
        f.format("%15.3e%n", 30.56456);
        f.format("%-15x%n", 12534);
        f.format("%15h%n", 12534);
    }
}