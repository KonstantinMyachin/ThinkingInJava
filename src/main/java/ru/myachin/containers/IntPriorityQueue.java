package ru.myachin.containers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 11. Создайте класс с полем {@link Integer}, которое инициализируется значением от <tt>0 до 100</tt> средствами
 * {@link Random}. Реализуйте интерфейс {@link Comparable} с использованием этого поля {@link Integer}. Заполните
 * {@link PriorityQueue} объектами своего класса и извлеките значения методом {@link Queue#poll()}, чтобы показать, что
 * они извлекаются в нужном порядке.
 */
public class IntPriorityQueue {

    public static void main(String[] args) {
        Queue<IntegerHolder> queue = new PriorityQueue<>(Arrays.asList(
                new IntegerHolder(), new IntegerHolder(), new IntegerHolder()
        ));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

class IntegerHolder implements Comparable<IntegerHolder> {

    private static final Random RANDOM = new Random(5);
    private final Integer i = RANDOM.nextInt(100);

    @Override
    public int compareTo(IntegerHolder o) {
        return (i < o.i) ? -1 : ((i == o.i) ? 0 : 1);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}