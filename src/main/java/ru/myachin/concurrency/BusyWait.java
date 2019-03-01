package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 22. Реализуйте пример активного ожидания. Одна задача приостанавливается на некоторое время, после чего устанавливает
 * флаг. Вторая задача следит за флагом в цикле <tt>while</tt> (активное поведение), и когда флаг принимает значение
 * <tt>true</tt>, сбрасывает его в состояние <tt>false</tt> и выводит информацию об изменении на консоль. Обратите
 * внимание, сколько времени программа проводит в активном ожидании, и создайте вторую версию программы, использующую
 * {@link Object#wait()} вместо активного ожидания.
 */
public class BusyWait {

    static volatile boolean flag;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Task());
        executor.execute(new BusyWaitedTask());
        executor.shutdown();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");
        }

        BusyWait.flag = true;
    }
}

class BusyWaitedTask implements Runnable {

    @Override
    public void run() {
        while (!BusyWait.flag) {
            System.out.println("Waiting...");
        }

        BusyWait.flag = false;
        System.out.println("Flag was Changed");
    }
}