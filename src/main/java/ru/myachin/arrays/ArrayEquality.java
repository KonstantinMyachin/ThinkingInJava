package ru.myachin.arrays;

import java.util.Arrays;

/**
 * 19. Создайте класс с полем <tt>int</tt>, инициализируемым по аргументу конструктора. Создайте два массива таких
 * объектов, используя идентичные значения инициализации для каждого массива, и покажите, что по мнению
 * {@link Arrays#equals(Object[], Object[])} они не равны. Добавьтие в класс метод <tt>equals()</tt> для решения
 * проблемы.
 */
public class ArrayEquality {

    public static void main(String[] args) {
        IntegerData[] array = {
                new IntegerData(1), new IntegerData(2)
        };

        IntegerData[] anotherArray = {
                new IntegerData(1), new IntegerData(2)
        };

        System.out.println(Arrays.equals(array, anotherArray));
    }
}

class IntegerData implements Comparable<IntegerData> {

    private final int i;

    IntegerData(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerData that = (IntegerData) o;
        return i == that.i;
    }

    @Override
    public int compareTo(IntegerData o) {
        return (i < o.i) ? -1 : ((i == o.i) ? 0 : 1);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
