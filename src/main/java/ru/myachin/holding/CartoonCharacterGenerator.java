package ru.myachin.holding;

import java.util.*;

/**
 * 4. Создайте класс-генератор, который при каждом вызове <b>next</b> выдает имена персонажей вашего любимого фильма в
 * виде объектов {@link String}. Когда список заканчиывается, программа снова возвращается к началу. Используйте
 * генератор для заполнения массива и контейнеров {@link ArrayList}, {@link LinkedList}, {@link HashSet},
 * {@link LinkedHashSet} и {@link TreeSet}, после чего выведите содержимое каждого контейнера.
 */
public class CartoonCharacterGenerator {

    private int index;

    public static void main(String[] args) {
        CartoonCharacterGenerator generator = new CartoonCharacterGenerator();
        String[] array = new String[9];
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = generator.next();
        }

        List<String> arrayAsList = Arrays.asList(array);
        List<String> arrayList = new ArrayList<>(arrayAsList);
        List<String> linkedList = new LinkedList<>(arrayAsList);
        Set<String> hashSet = new HashSet<>(arrayAsList);
        Set<String> linkedHashSet = new LinkedHashSet<>(arrayAsList);
        Set<String> treeSet = new TreeSet<>(arrayAsList);

        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }

    public String next() {
        return CartoonCharacter.getNameByOrdinal(++index);
    }

    private enum CartoonCharacter {

        TOM("Том"),
        JERRY("Джерри"),
        BUTCH("Бач"),
        FLAPPER("Флэппер");

        private final String name;

        CartoonCharacter(String name) {
            this.name = name;
        }

        private static String getNameByOrdinal(int ordinal) {
            CartoonCharacter[] values = values();
            for (CartoonCharacter character : values) {
                if (ordinal % values.length == character.ordinal()) {
                    return character.name;
                }
            }

            throw new IllegalArgumentException("Соответствующий мультперсонаж не найден в справочнике.");
        }
    }
}