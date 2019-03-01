package ru.myachin.holding;

import java.util.*;

/**
 * 6. Измените пример <b>ListFeatures.java</b>, чтобы вместо объектов <b>Pet</b> в нем использовались объекты
 * {@link String}. Объясните различия в результатах
 */
public class StringListFeatures {

    public static void main(String[] args) {
        Random random = new Random(5);
        List<String> list = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        System.out.println("1: " + list);
        String h = "Six";
        list.add(h);
        System.out.println("2: " + list);
        System.out.println("3: " + list.contains(h));
        list.remove(h);
        String p = list.get(2);
        System.out.println("4: " + p + " " + list.indexOf(p));
        String c = "Seven";
        System.out.println("5: " + list.indexOf(c));
        System.out.println("6: " + list.remove(c));
        System.out.println("7: " + list.remove(p));
        System.out.println("8: " + list);
        list.add(3, "Ten");
        System.out.println("9: " + list);
        List<String> sub = list.subList(1, 4);
        System.out.println("Частичный список: " + sub);
        System.out.println("10: " + list.containsAll(sub));
        Collections.sort(sub);
        System.out.println("После сортировки " + sub);
        System.out.println("11: " + list.containsAll(sub));
        Collections.shuffle(sub, random);
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + list.containsAll(sub));
        List<String> copy = new ArrayList<>(list);
        sub = Arrays.asList(list.get(1), list.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("copy:" + copy);
        copy = new ArrayList<>(list);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, "Java");
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + list.isEmpty());
        list.clear();
        System.out.println("19: " + list);
        System.out.println("20: " + list.isEmpty());
        list.addAll(Arrays.asList("1", "2", "3", "4", "5"));
        System.out.println("21: " + list);
        Object[] o = list.toArray();
        System.out.println("22: " + o[3]);
        String[] strings = list.toArray(new String[0]);
        System.out.println("23: " + strings[3]);
    }
}
