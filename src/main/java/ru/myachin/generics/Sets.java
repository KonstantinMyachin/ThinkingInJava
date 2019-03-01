package ru.myachin.generics;

import net.mindview.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 17. Изучите документацию JDK по {@link EnumSet} и найдите в нем метод {@link EnumSet#clone()}. Однако ссылки на
 * интерфейс {@link Set}, передаваемой в {@link net.mindview.util.Sets}, метод {@link Object#clone()} вызываться не
 * может. Удастся ли вам изменить код {@link net.mindview.util.Sets} таким образом, чтобы он обрабатывал как общий
 * случай интерфейса {@link Set}, так и особый случай {@link EnumSet}, используя {@link Object#clone()} вместо
 * создания нового объекта {@link HashSet}.
 */
public class Sets {

    @SuppressWarnings("unchecked")
    private static <E> Set<E> cloneSet(Set<E> set) {
        if (set instanceof EnumSet) {
            return ((EnumSet) set).clone();
        } else if (set instanceof HashSet) {
            return ((HashSet) ((HashSet<E>) set).clone());
        }

        return new HashSet<>(set);
    }

    private static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = cloneSet(a);
        result.addAll(b);
        return result;
    }

    private static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = cloneSet(a);
        result.retainAll(b);
        return result;
    }

    private static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = cloneSet(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));
        System.out.println("union(set1, set2) type: " + Sets.union(set1, set2).getClass().getSimpleName());
        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        Set<Integer> set4 = new HashSet<>();
        set4.add(2);
        System.out.println("set3: " + set3);
        System.out.println("set4: " + set4);
        System.out.println("union(set3, set4): " + Sets.union(set3, set4));
        System.out.println("union(set3, set4) type: " + Sets.union(set3, set4).getClass().getSimpleName());
    }
}
