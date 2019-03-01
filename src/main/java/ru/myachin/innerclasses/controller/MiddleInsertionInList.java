package ru.myachin.innerclasses.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 14. Создайте пустой контейнер {@link LinkedList} для {@link Integer}. Используя {@link ListIterator}, добавьте в
 * {@link List} значения {@link Integer}; все операции вставки должны осуществляться в середине списка.
 */
public class MiddleInsertionInList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator();

        for (int i = 1; i < 10; i++) {
            iterator.add(i);
            if (i % 2 == 0) {
                iterator.previous();
            }
        }

        System.out.println(list);
    }
}
