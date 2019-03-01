package ru.myachin.holding;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 28. Заполните контейнер {@link DoublePriorityQueue} (с использование метода {@link Queue#offer(Object)}) значениями
 * {@link Double}, созданные геренатором {@link Random}. Извлеките элементы из очереди методом {@link Queue#poll()}
 * и выведите их.
 */
public class DoublePriorityQueue {

    public static void main(String[] args) {
        Random random = new Random(5);
        Queue<Double> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextDouble());
        }

        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}