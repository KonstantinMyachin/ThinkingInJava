package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 12. Исправьте ошибку в <tt>AtomicityTest.java</tt>, используя ключевое слово <tt>synchronized</tt>. Сможете ли вы
 * продемонстрировать, что теперь программа работает верно?
 */
public class AtomicityTest implements Runnable {
    private int i = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    private synchronized int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}
