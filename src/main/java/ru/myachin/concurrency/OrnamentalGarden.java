package ru.myachin.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 19. Измените примре {@link net.mindview.concurrency.OrnamentalGarden} так, чтобы в нем использовался метод
 * {@link Thread#interrupt()}
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }

        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MICROSECONDS)) {
            System.out.println("Some tasks were not terminated!");
        }

        System.out.println(String.format("Total: %d", Entrance.getTotalCount()));
        System.out.println(String.format("Sum of Entrances: %d", Entrance.sumEntrances()));
    }

}

class Entrance implements Runnable {

    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private final int id;
    private int number;

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }

        return sum;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                ++number;
            }

            System.out.println(String.format("%s Total: %d", this, count.increment()));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(String.format("Stopping %s", this));
                break;
            }
        }
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Entrance id: %d", getValue());
    }
}

class Count {
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}