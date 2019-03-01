package ru.myachin.containers;

import net.mindview.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. Создайте контейнер {@link List} (опробуйте как {@link ArrayList}, так и {@link LinkedList}) и заполните его
 * данными {@link Countries}. Отсортируйте список и выведите его, затем многократно примените к списку
 * {@link Collections#shuffle(List)}. После каждого применения выводите содержимое контейнера, чтобы было видно, что
 * метод {@link Collections#shuffle(List)} каждый раз переставляет элементы списка в разном порядке.
 */
public class ShuffledCountryList {

    public static void main(String[] args) {
        final List<String> names = Countries.names(50);
        List<String> countries = new ArrayList<>(names);
        Collections.sort(countries);
        for (int i = 0; i < 10; i++) {
            shuffleAndPrintList(countries);
        }

        countries = new LinkedList<>(names);
        Collections.sort(countries);
        for (int i = 0; i < 5; i++) {
            shuffleAndPrintList(countries);
        }
    }

    private static void shuffleAndPrintList(List<String> list) {
        Collections.shuffle(list);
        System.out.println(list);
    }
}
