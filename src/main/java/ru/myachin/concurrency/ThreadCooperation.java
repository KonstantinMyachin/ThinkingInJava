package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 21. Создайте два объекта {@link Runnable}, один содержит метод {@link Runnable#run()}, который запускает и вызывает
 * {@link Object#wait()}. Второй класс должен сохранять ссылку на первый объект {@link Runnable}. Его метод
 * {@link Runnable#run()} должен вызывать {@link Object#notifyAll()} для первой задачи после истечения некоторого
 * количества секунд, чтобы первая задач могла вывести сообщение. Протестируйте свои классы с помощью
 * {@link java.util.concurrent.Executor}
 */
public class ThreadCooperation {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        FirstTask task = new FirstTask();
        executor.execute(task);
        executor.execute(new SecondTask(task));
        executor.shutdown();
    }
}

class FirstTask implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
                System.out.println("Task was continued");
            } catch (InterruptedException e) {
                System.out.println("FirstTask interrupted");
            }
        }
    }
}

class SecondTask implements Runnable {

    FirstTask firstTask;

    public SecondTask(FirstTask firstTask) {
        this.firstTask = firstTask;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("SecondTask interrupted");
        }

        synchronized (firstTask) {
            firstTask.notifyAll();
        }
    }
}