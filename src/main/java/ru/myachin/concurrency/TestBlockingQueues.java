package ru.myachin.concurrency;

import net.mindview.concurrency.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * 28. Измените пример <tt>TestBlockingQueues.java</tt> и добавьте новую задачу, которая помещает {@link LiftOff} в
 * {@link BlockingQueue} (вместо того, чтобы делать это в <tt>main()</tt>)
 */
public class TestBlockingQueues {

    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        LiftOffProducer producer = new LiftOffProducer(runner);
        exec.execute(runner);
        exec.execute(producer);
        getKey("Press 'ENTER' (" + msg + ")");
        exec.shutdownNow();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
        test("SynchronousQueue", new SynchronousQueue<>());
    }
}

class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff lo) throws InterruptedException {
        rockets.put(lo);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (Exception e) {
            System.out.println("Waking from take()");
        }

        System.out.println("Exiting LiftOffRunner");
    }
}

class LiftOffProducer implements Runnable {
    private LiftOffRunner runner;

    public LiftOffProducer(LiftOffRunner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                runner.add(new LiftOff(5));
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from put()");
        }
        System.out.println("Exiting LiftOffProducer");
    }
}