package ru.myachin.containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * 7. Создайте объекты {@link ArrayList} и {@link LinkedList}, заполните каждый из них с использованием генератора
 * {@link Countries#names()}. Выведите список с использованием {@link Iterator обычного итератора}, затем вставьте один
 * список в другой с использованием {@link ListIterator}, выполняя вставку через позицию. Теперь выполните вставку,
 * начиная от конца первого списка и перемещаясь в обратном направлениии.
 */
public class ListInsertion {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Countries.names(25));
        List<String> linkedList = new LinkedList<>(Countries.names(50));
        printListThroughIterator(arrayList);
        printListThroughIterator(linkedList);
        insertThroughOnePosition(arrayList, linkedList);
        insertStartingReverseOrder(arrayList, linkedList);
    }

    private static void printListThroughIterator(List<String> list) {
        System.out.println(list.getClass().getSimpleName() + ":");
        final Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void insertThroughOnePosition(List<String> source, List<String> target) {
        final ListIterator<String> it = target.listIterator();
        for (String s : source) {
            if (it.hasNext() && (it.nextIndex() % 2) == 0) {
                it.next();
                it.add(s);
            }
        }

        printListThroughIterator(target);
    }

    private static void insertStartingReverseOrder(List<String> source, List<String> target) {
        final ListIterator<String> sourceIt = source.listIterator(source.size());
        final ListIterator<String> targetIt = target.listIterator();
        while (sourceIt.hasPrevious()) {
            if (targetIt.hasNext() && (targetIt.nextIndex() % 2) == 0) {
                targetIt.next();
                targetIt.add(sourceIt.previous());
            }
        }

        printListThroughIterator(target);
    }
}
