package ru.myachin.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 32. Используйте <tt>CountDownLatch</tt> для решения задачи корреляции результатов отдельных входов в
 * {@link net.mindview.concurrency.OrnamentalGarden}. Удалите лишний код из новой версии примера
 */
public class CountDownLatchOrnamentalGarden {

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Gate(latch, i));
        }
        TimeUnit.SECONDS.sleep(3);
        Gate.cancel();
        exec.shutdown();
        latch.await();
        System.out.println("Total: " + Gate.getTotalCount());
        System.out.println("Sum of Entrances: " + Gate.sumEntrances());
    }
}

class Gate implements Runnable {
    
    private static Count count = new Count();
    private static List<Gate> gates = new ArrayList<>();
    private static volatile boolean canceled;
    private final CountDownLatch latch;
    private final int id;
    private int number;

    public Gate(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
        gates.add(this);
    }

    public static void cancel() {
        canceled = true;
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Gate gate : gates) {
            sum += gate.getValue();
        }

        return sum;
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        latch.countDown();
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Gate " + id + ": " + getValue();
    }
}