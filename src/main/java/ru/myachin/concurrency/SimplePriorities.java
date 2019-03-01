package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 9. Измените пример <tt>SimplePriorities.java</tt>, чтобы пользовательская реализация {@link ThreadFactory} задавала
 * приоритеты потоков.
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }

            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        class PriorityThreadFactory implements ThreadFactory {

            private final int priority;

            public PriorityThreadFactory(int priority) {
                this.priority = priority;
            }

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(priority);
                return thread;
            }
        }

        ExecutorService executor = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
        for(int i = 0; i < 5; i++) {
            executor.execute(new SimplePriorities());
        }
        executor.shutdown();

        executor = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
        executor.execute(new SimplePriorities());
        executor.shutdown();
    }
}
