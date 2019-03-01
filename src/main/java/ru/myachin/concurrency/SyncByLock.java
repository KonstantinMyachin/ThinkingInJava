package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 16. Измените {@link SyncObject упражнение 15} так, чтобы в нем использовались явные блокировки с объектами
 * {@link Lock}
 */
public class SyncByLock {

    void doSomething(Lock lock) {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("doSomething()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    void doSomethingElse(Lock lock) {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("doSomethingElse()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    void oneMoreMethod(Lock lock) {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("oneMoreMethod()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println("Synchronized by single lock object");
        ExecutorService executor = Executors.newCachedThreadPool();
        SyncByLock syncObject = new SyncByLock();
        Lock lock = new ReentrantLock();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomething(lock);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomethingElse(lock);
            }
        });

        executor.shutdown();
        syncObject.oneMoreMethod(lock);

        System.out.println("Synchronized by different lock objects");
        executor = Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomething(new ReentrantLock());
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.doSomethingElse(new ReentrantLock());
            }
        });

        executor.shutdown();
        syncObject.oneMoreMethod(lock);

    }
}
