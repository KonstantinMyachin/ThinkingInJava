package ru.myachin.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 29. Создайте обобщенный метод, который получает аргумент <tt>Holder<List<?>></tt>. Определите, какие методы могут
 * или не могут вызываться длы {@link Holder} м для {@link List}. Повторите для аргумента <tt>List<Holder<?>></tt>
 */
public class WildCards {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        doSomething(new Holder<>(list1, list1, list1));
        List<Holder<?>> list2 = new ArrayList<>();
        list2.add(new Holder<>(1, 1, 1));
        doSomethingElse(list2);
    }

    private static void doSomething(Holder<List<?>> holder) {
        List<?> list = holder.getFirst();
        System.out.println(holder.equals(list));
        Integer i = (Integer) list.get(0);
        System.out.println(i);
        System.out.println(list.contains(i));
        System.out.println(list.remove(i));
        holder.setFirst(new ArrayList<Float>());
    }

    private static void doSomethingElse(List<Holder<?>> list) {
        Holder<?> holder = list.get(0);
        System.out.println(holder.equals(Integer.valueOf(1)));
        System.out.println(holder.getFirst());
        list.add(new Holder<>(1.0f, 1.0f, 1.0f));
        System.out.println(list.get(1).getFirst());
        list.remove(0);
        System.out.println(list.size());
    }
}
