package ru.myachin.arrays;

/**
 * 11. Покажите, что автоматическая упаковка не работает с массивами.
 */
public class ArraysAutoBoxing {

    public static void main(String[] args) {
        int[] iArray = new int[10];
        //Integer[] integers = iArray; compile error
        Integer[] integers = new Integer[10];
        //iArray = integers; compile error
    }
}
