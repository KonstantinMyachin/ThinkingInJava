package ru.myachin.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 10. Измените пример <tt>ArrayOfGenerics.java</tt>, чтобы вместо массивов в нем использовались контейнеры. Покажите,
 * что предупреждения компилятора можно устранить.
 */
public class ArrayOfGenerics {

    public static void main(String[] args) {
        ArrayList<List<String>> ls = new ArrayList<>();
        ls.add(new ArrayList<>());
        ls.get(0).add("Array of Generics");
        System.out.println(ls.toString());
    }
}
