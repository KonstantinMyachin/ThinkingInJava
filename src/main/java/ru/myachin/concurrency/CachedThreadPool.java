package ru.myachin.concurrency;

import net.mindview.concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 20. Измените пример <tt>CachedThreadPool.java</tt> так, чтобы все задачи получали {@link Thread#interrupt()} перед
 * завершением.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdownNow();
    }
}
