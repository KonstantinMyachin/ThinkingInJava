package ru.myachin.initialization;

/**
 * 16. Создайте массив объектов {@link String}. Присвойте объект {@link String} каждому элементу. Выведите содержимое
 * массива в цикле <b>for</b>.
 */
public class StringArray {

    public static void main(String[] args) {
        String[] array = {
                "One", "Two", "Three", "Four", "Five"
        };

        for (int i = 0, n = array.length; i < n; i++) {
            System.out.println(array[i]);
        }
    }
}
