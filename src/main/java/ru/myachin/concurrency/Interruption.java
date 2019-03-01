package ru.myachin.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * 18. Создайте класс, не являющийся задачей, с методом, который вызывает {@link Thread#sleep(long)} на долгий
 * промежуток времени. Создайте задачу, которая вызывает метод первого класса. В <tt>main</tt> запустите задачу и
 * прервите ее методом {@link Thread#interrupt()}. Убедитесь в том, что задача завершилась корректно.
 */
public class Interruption {

    public void longSleep() {
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(String.format("%s was interrupted", Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Interruption interruption = new Interruption();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                interruption.longSleep();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
