package ru.myachin.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 14. Продемонстрируйте масштабируемость кода {@link Timer} - создайте программу, которая генерирует множество объектов
 * {@link Timer}, выполняющих какую-нибудь простую операцию по тайм-ауту
 */
public class Timers {

    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        for (int i = 0; i < count; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(System.nanoTime());
                }
            }, 0, count);
        }

        TimeUnit.MILLISECONDS.sleep(2 * count);
        System.exit(0);
    }
}
