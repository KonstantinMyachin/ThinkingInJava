package ru.myachin.holding;

import java.util.*;

/**
 * 23. Взяв за отправную точку программу <b>Statistics.java</b>, создайте программу, которая циклически повторяет этот
 * тест, проверяя, не появляется ли какое-либо из полученных случайных чисел чаще других.
 */
public class MoreProbable {

    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 500000; i++) {
            int r = random.nextInt(100);
            m.put(r, m.containsKey(r) ? m.get(r) + 1 : 1);
        }

        List<IntegerCounter> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            list.add(new IntegerCounter(entry.getKey(), entry.getValue()));
        }

        list.sort(Comparator.reverseOrder());
        for (IntegerCounter integerCounter : list) {
            System.out.println(integerCounter);
        }
    }

    private static class IntegerCounter implements Comparable<IntegerCounter> {

        private final Integer value;

        private final Integer count;

        public IntegerCounter(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(IntegerCounter o) {
            return count.compareTo(o.count);
        }

        @Override
        public String toString() {
            return "Value: " + value + " count: " + count;
        }
    }
}
