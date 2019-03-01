package ru.myachin.holding;

import java.util.*;

/**
 * 5. Измените пример <b>ListFeatures.java</b>, чтобы вместо объектов <b>Pet</b> в нем использовались значения
 * {@link Integer} (не забудьте про автоматическую упаковку!). ОБъясните различия в результатах.
 */
public class IntegerListFeatures {

    public static void main(String[] args) {
        Random random = new Random(5);
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("1: " + list);
        int h = random.nextInt();
        list.add(h);
        System.out.println("2: " + list);
        System.out.println("3: " + list.contains(h));
        list.remove(Integer.valueOf(h)); //приходится использовать обертку, иначе вызвается удаление по индексу
        int p = list.get(2);
        System.out.println("4: " + p + " " + list.indexOf(p));
        int c = random.nextInt();
        System.out.println("5: " + list.indexOf(c));
        System.out.println("6: " + list.remove(Integer.valueOf(c))); //аналогичная ситуация
        System.out.println("7: " + list.remove(Integer.valueOf(p)));
        System.out.println("8: " + list);
        list.add(3, 55);
        System.out.println("9: " + list);
        List<Integer> sub = list.subList(1, 4);
        System.out.println("Частичный список: " + sub);
        System.out.println("10: " + list.containsAll(sub));
        Collections.sort(sub);
        System.out.println("После сортировки " + sub);
        System.out.println("11: " + list.containsAll(sub));
        Collections.shuffle(sub, random);
        System.out.println("После перемешивания: " + sub);
        System.out.println("12: " + list.containsAll(sub));
        List<Integer> copy = new ArrayList<>(list);
        sub = Arrays.asList(list.get(1), list.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("copy:" + copy);
        copy = new ArrayList<>(list);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, 555);
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + list.isEmpty());
        list.clear();
        System.out.println("19: " + list);
        System.out.println("20: " + list.isEmpty());
        list.addAll(Arrays.asList(11, 22, 33, 44, 55));
        System.out.println("21: " + list);
        Object[] o = list.toArray();
        System.out.println("22: " + o[3]);
        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println("23: " + integers[3]);
    }
}