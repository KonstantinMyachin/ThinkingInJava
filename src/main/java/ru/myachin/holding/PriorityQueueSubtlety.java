package ru.myachin.holding;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 29. Создайте простой класс, производный от {@link Object} и не содержащий членов. Покажите, что множественные
 * элементы этого класса не могут быть добавлены в {@link PriorityQueue}. Проблема будет более подробно рассмотрена
 * в главе 17.
 */
public class PriorityQueueSubtlety {

    public static void main(String[] args) {
        Queue<PriorityQueueSubtlety> queue = new PriorityQueue<>(Arrays.asList(new PriorityQueueSubtlety(),
                new PriorityQueueSubtlety()));
    }
}