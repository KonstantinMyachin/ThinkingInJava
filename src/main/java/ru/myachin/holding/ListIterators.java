package ru.myachin.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 12. Создайте и заполните контейнер <b>List Integer</b>. Создайте второй контейнер <b>List Integer</b> того же
 * размера. Используйте итераторы {@link ListIterator} для чтения элементов из первого контейнера {@link List} и вставки
 * их во второй контейнер в обратном порядке. (Проанализируйте несколько разных способов решения этой задачи.)
 */
public class ListIterators {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int size = list.size();
        List<Integer> reverseList = new ArrayList<>(size);

        ListIterator<Integer> listIterator = list.listIterator(size);
        while (listIterator.hasPrevious()) {
            reverseList.add(listIterator.previous());
        }

        for (Integer integer : reverseList) {
            System.out.println(integer);
        }
    }
}
