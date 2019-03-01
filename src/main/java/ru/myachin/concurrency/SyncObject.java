package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 15. Создайте класс с тремя методами, содержащими критические секции, синхронизируемые по одному объекту. Создайте
 * несколько задач, демонстрирующих, что в любой момент времени может выполняться только один из этих методов. Теперь
 * измените методы, чтобы каждый из них синхронизировался по своему объекту, и пкоажите, что все методы могут
 * выполняться одновременно.
 */
public class SyncObject {

    public static void main(String[] args) {
        System.out.println("Synchronized by single object");
        ExecutorService executor = Executors.newCachedThreadPool();
        SyncObject syncObject = new SyncObject();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomething(syncObject);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomethingElse(syncObject);
            }
        });

        executor.shutdown();
        syncObject.oneMoreMethod(syncObject);

        System.out.println("Synchronized by different objects");
        executor = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomething(new Object());
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomethingElse(new Object());
            }
        });

        executor.shutdown();
        syncObject.oneMoreMethod(syncObject);
    }

    void doSomething(Object syncObject) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("doSomething()");
                Thread.yield();
            }
        }
    }

    void doSomethingElse(Object syncObject) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("doSomethingElse()");
                Thread.yield();
            }
        }
    }

    void oneMoreMethod(Object syncObject) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("oneMoreMethod()");
                Thread.yield();
            }
        }
    }
}
