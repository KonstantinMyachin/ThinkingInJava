package ru.myachin.concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 31. Измените пример <tt>DeadlockingDiningPhilosophers.java</tt> так, чтобы когда философ завершает пользоваться
 * палочками, он бросает их в корзину. Когда философ собирается поесть, он берет две палочки из корзины. Устраняет ли
 * это возможность взаимной блокировки? Можно ли ввести риск взаимной блокировки простым сокращением количества палочек?
 */
public class DeadlockingDiningPhilosophers {

    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }

        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        BlockingQueue<Chopstick> queue = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            queue.put(new Chopstick());
        }

        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(queue, i, ponder));
        }

        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }

        exec.shutdownNow();
    }
}

class Chopstick {

    private boolean taken;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }

        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}

class Philosopher implements Runnable {

    private BlockingQueue<Chopstick> queue;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    public Philosopher(BlockingQueue<Chopstick> queue, int id, int ponderFactor) {
        this.queue = queue;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }

        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking");
                pause();
                System.out.println(this + " grabbing right");
                Chopstick right = queue.take();
                System.out.println(this + " grabbing left");
                Chopstick left = queue.take();
                System.out.println(this + " eating");
                pause();
                queue.put(right);
                queue.put(left);
            }
        } catch (Exception e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}