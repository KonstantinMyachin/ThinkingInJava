package ru.myachin.concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 30. Измените пример <tt>PipedIO.java</tt>, чтобы в нем вместо канала использовалась очередь {@link BlockingQueue}
 */
public class SendReceive {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private BlockingQueue<Character> out = new LinkedBlockingQueue<>();

    public BlockingQueue<Character> getQueue() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender interrupted");
        }
    }
}

class Receiver implements Runnable {
    private BlockingQueue<Character> in;

    public Receiver(Sender sender) {
        in = sender.getQueue();
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Read: " + in.take() + ", ");
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Reader interrupted");
        }
    }
}