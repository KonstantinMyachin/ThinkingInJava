package ru.myachin.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1. Реализуйте интерфейс {@link Runnable}. В методе {@link Runnable#run()} выведитие сообщение, после чего вызовите
 * {@link Thread#yield()}. Повторите три раза и верните управление из {@link Runnable#run()}. Выведите начальное
 * сообщение в конструкторе, а при завершении выведите конеченое сообщение. Создайте несколько задач и организуйте их
 * выполнение с использование потоков.
 * <p>
 * 3. Повторите упражнение 1 с разными типами {@link Executor}, описанными в этом разделе
 */
public class RunnableImpl implements Runnable {

    private static int counter;
    private final int id = ++counter;

    private RunnableImpl() {
        System.out.println(String.format("Creating %s", this));
    }

    public static void main(String[] args) {
        manualThreadMenage();
        serviceThreadMenage(Executors.newSingleThreadExecutor());
        serviceThreadMenage(Executors.newCachedThreadPool());
        serviceThreadMenage(Executors.newFixedThreadPool(5));
    }

    @Override
    public String toString() {
        return String.format("Task #%d", id);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("%s is doing", this));
            Thread.yield();
        }

        System.out.println(String.format("%s was done", this));
    }

    private static void manualThreadMenage() {
        for (int i = 0; i < 5; i++) {
            new Thread(new RunnableImpl()).start();
        }
    }

    private static void serviceThreadMenage(ExecutorService executor) {
        for (int i = 0; i < 5; i++) {
            executor.execute(new RunnableImpl());
        }

        executor.shutdown();
    }
}
