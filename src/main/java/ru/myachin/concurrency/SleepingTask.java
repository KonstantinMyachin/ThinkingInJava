package ru.myachin.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 6. Создайте задачу, которая приостанавливается на случайный промежуток времени от <tt>1</tt> до <tt>10</tt> секунд,
 * затем выводит время ожидания и завершается. Создайте и запустите несколько таких задач (количество должно
 * задаваться в командной строке)
 */
public class SleepingTask implements Runnable {

    private static final Random RANDOM = new Random(47);

    @Override
    public void run() {
        int timeout = RANDOM.nextInt(10) + 1;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e);
        }
        System.out.println("Thread was slept during " + timeout + "sec.");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SleepingTask countOfTasks");
            System.exit(-1);
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0, n = Integer.parseInt(args[0]); i < n; i++) {
            executor.execute(new SleepingTask());
        }

        executor.shutdown();
    }
}
