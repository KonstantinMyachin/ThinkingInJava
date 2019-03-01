package ru.myachin.arrays;

import java.util.Arrays;

/**
 * 5. Продемонстрируйте, что многомерные массивы непримитивных типов автоматически инициализируются <tt>null</tt>.
 */
public class NonPrimitiveArrayInitialization {

    public static void main(String[] args) {
        BerylliumSphere[][] array = new BerylliumSphere[5][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == null) {
                    System.out.println("Null initialization");
                }
            }
        }

        System.out.println(Arrays.deepToString(array));
    }
}
