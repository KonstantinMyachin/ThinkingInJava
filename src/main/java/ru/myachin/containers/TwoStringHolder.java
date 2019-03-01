package ru.myachin.containers;

import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

import java.util.*;

/**
 * 40. Создайте класс, содержащий два объекта {@link String}, и реализуйте для этого класса интерфейс {@link Comparable}
 * так, чтобы его метод проводил сравнение с учетом только первой строки. Заполните массив и список {@link ArrayList}
 * объектами этого класса, применив генератор {@link RandomGenerator}. Покажите, что сортировка работает правильно.
 * Теперь создайте объект {@link Comparator}, который проводит сравнение с учетом только второй строки, после чего
 * покажите, что и в этом случае сравнение проходит верно, выполните также двоичный двоичный поиск
 * {@link Collections#binarySearch(List, Object, Comparator)} с использованием вашего объекта {@link Comparator}
 * <p>
 * 41. Измените класс из предыдущего упражнения так, чтобы он работал с {@link HashSet} и использовался в качестве ключа
 * в {@link HashMap}.
 * <p>
 * 42. Измените упражнение 40 так, чтобы в нем использовалась сортировка по алфавиту.
 */
public class TwoStringHolder implements Comparable<TwoStringHolder> {

    private static Generator<String> generator = new RandomGenerator.String(10);
    private final String s1 = generator.next();
    private final String s2 = generator.next();

    public static Generator<TwoStringHolder> generator() {
        return new Generator<TwoStringHolder>() {
            @Override
            public TwoStringHolder next() {
                return new TwoStringHolder();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoStringHolder that = (TwoStringHolder) o;

        if (!s1.equals(that.s1)) return false;
        return s2.equals(that.s2);
    }

    @Override
    public int hashCode() {
        int result = s1.hashCode();
        result = 31 * result + s2.hashCode();
        return result;
    }

    @Override
    public int compareTo(TwoStringHolder o) {
        return s1.compareTo(o.s1);
    }

    @Override
    public String toString() {
        return String.format("s1: %s; s2: %s", s1, s2);
    }

    public static void main(String[] args) {
        TwoStringHolder[] twoStringHolders = new TwoStringHolder[5];
        Generated.array(twoStringHolders, TwoStringHolder.generator());
        Arrays.sort(twoStringHolders);
        System.out.println(Arrays.toString(twoStringHolders));
        List<TwoStringHolder> list = Arrays.asList(twoStringHolders);

        Comparator<TwoStringHolder> secondStringComparator = new Comparator<TwoStringHolder>() {
            @Override
            public int compare(TwoStringHolder o1, TwoStringHolder o2) {
                return o1.s2.compareTo(o2.s2);
            }
        };

        Collections.sort(list, secondStringComparator);
        System.out.println(list);
        TwoStringHolder thirdStringHolder = list.get(2);
        System.out.println(Collections.binarySearch(list, thirdStringHolder, secondStringComparator));
        HashSet<TwoStringHolder> set = new HashSet<>(list);
        System.out.println(set);
        HashMap<TwoStringHolder, String> map = new HashMap<>();
        map.put(thirdStringHolder, thirdStringHolder.s1);
        System.out.println(map);

        Comparator<TwoStringHolder> alphabeticComparator = new Comparator<TwoStringHolder>() {
            @Override
            public int compare(TwoStringHolder o1, TwoStringHolder o2) {
                return o1.s1.toLowerCase().compareTo(o2.s1.toLowerCase());
            }
        };

        Collections.sort(list, alphabeticComparator);
        System.out.println(list);
    }
}