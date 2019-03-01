package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 11. Создайте класс с двумя полями данных и методом, который работает с тэими полями в несколько этапов, чтобы во
 * время выполнения метода поля находились в "некорректном состоянии" (по тому определению, которое вы установите).
 * Добавьте методы чтения полей; создайте несколько потоков, в которырх эти методы будут вызваться, и покажиет, что
 * данные находятьсяв некорректном состоянии. Решите проблемы при помощи ключевого слова <tt>synchronized</tt>.
 */
public class RaceCondition implements Runnable {

    private Condition condition;

    public RaceCondition(Condition condition) {
        this.condition = condition;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e);
            }
        });

        System.out.println("Press Control-C to exit");
        Condition condition = new Condition();
        for (int i = 0; i < 10; i++) {
            executor.execute(new RaceCondition(condition));
        }

        executor.shutdown();
    }

    @Override
    public void run() {
        while (true) {
            condition.doLegalState("Condition");
        }
    }
}

class Condition {

    private int id = 0;
    private String name = "";

    public synchronized void doLegalState(String name) {
        Thread.yield();
        if (id == 0) {
            id++;
        }
        Thread.yield();
        if (this.name.equals("")) {
            this.name = name;
        }

        validate();
    }

    private synchronized void validate() {
        if (--id != 0 || name.equals("")) {
            throw new IllegalStateException();
        }
    }
}
