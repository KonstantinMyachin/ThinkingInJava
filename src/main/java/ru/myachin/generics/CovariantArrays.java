package ru.myachin.generics;

/**
 * 26. Продемонстрируйте ковариантность массивов на примере {@link Number} и {@link Integer}.
 */
public class CovariantArrays {

    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
        numbers[0] = 4;
        numbers[1] = 2;
        try {
            numbers[2] = 2.0;
        } catch (ArrayStoreException e) {
            System.out.println(e);
        }

        for (Number number : numbers) {
            System.out.println(number);
        }
    }
}
