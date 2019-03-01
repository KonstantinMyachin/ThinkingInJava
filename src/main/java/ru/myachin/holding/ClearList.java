package ru.myachin.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3. Создайте класс, затем создайте инициализированный массив объектов этого класса. Заполните контейнер {@link List}
 * данными массива. Создайте подмножество {@link List} метомод {@link List#subList(int, int)}, после чего удалите это
 * множество из вашего контейнера {@link List}
 */
public class ClearList {

    public static void main(String[] args) {
        ClearList[] array = {
                new ClearList(), new ClearList(), new ClearList()
        };

        List<ClearList> list = new ArrayList<>(Arrays.asList(array));
        List<ClearList> subList = list.subList(0, 2);
        list.removeAll(subList);
        System.out.println(list.size());
    }
}
