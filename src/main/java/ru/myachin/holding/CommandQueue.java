package ru.myachin.holding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 27. Напишите класс с именем <b>Command</b>, который содержит поле {@link String} и метод <b>operation()</b>,
 * выводящему {@link String}. Напишите второй класс с методом, который заполняет контейнер {@link Queue} объектами
 * <b>Command</b> и выводит его. Передайте заполненный контейнер {@link Queue} методу третьего класса, перебирающему
 * объекты {@link Queue} и вызывающему их методы <b>operation()</b>.
 */
public class CommandQueue {

    public static void main(String[] args) {
        Queue<Command> queue = new LinkedList<>();
        Producer.produce(queue);
        Consumer.consume(queue);
    }
}

class Command {

    private String s;

    public Command(final String s) {
        this.s = s;
    }

    public void operation() {
        System.out.println(s);
    }
}

class Producer {

    static void produce(Queue<Command> queue) {
        queue.offer(new Command("Create"));
        queue.offer(new Command("Update"));
        queue.offer(new Command("Delete"));
    }
}

class Consumer {

    static void consume(Queue<Command> queue) {
        if (!queue.isEmpty()) {
            while (queue.peek() != null) {
                queue.poll().operation();
            }
        }
    }
}