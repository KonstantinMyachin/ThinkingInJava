package ru.myachin.arrays;

/**
 * 1. Создайте метод, получающий в аргументе массив объектов {@link BerylliumSphere}. Вызовите метод с динамическим
 * созданием аргумента. Продемонстрируйте , что обычная групповая инициализация массива в этом случае не работает.
 * Найдите ситуации, в которых обычная групповая инициализация массива работает, а динамическая групповая инициализация
 * оказывается излишней.
 */
public class ArrayInitialization {

    public static void main(String[] args) {
        printArray(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});
//        printArray({new BerylliumSphere(), new BerylliumSphere()}); compile error
        BerylliumSphere[] array = {
                new BerylliumSphere(), new BerylliumSphere()
        };

        printArray(array);
    }

    private static void printArray(BerylliumSphere... array) {
        for (BerylliumSphere berylliumSphere : array) {
            System.out.println(berylliumSphere);
        }
    }
}

class BerylliumSphere implements Comparable<BerylliumSphere> {

    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }

    @Override
    public int compareTo(BerylliumSphere o) {
        final long i = o.getId();
        return (id < i) ? -1 : ((id == i) ? 0 : 1);
    }

    public long getId() {
        return id;
    }
}