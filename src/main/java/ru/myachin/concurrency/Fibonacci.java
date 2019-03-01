package ru.myachin.concurrency;

import net.mindview.util.Generator;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2. По образцу {@link net.mindview.generics.Fibonacci} создайте задачу, которая генерирует последовательность из
 * <tt>n</tt> числе Фибонначи (значение <tt>n</tt> передается в конструкторе задачи). Создайте несколько таких задач
 * и выполните их в поток.
 * <p>
 * 4. Повторите упражнение 2 с разными типами {@link Executor}, описанными в этом разделе.
 */
public class Fibonacci implements Generator<Integer>, Runnable {

    private final int n;
    private int count;

    private Fibonacci(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        manualThreadMenage();
        serviceThreadMenage(Executors.newSingleThreadExecutor());
        serviceThreadMenage(Executors.newCachedThreadPool());
        serviceThreadMenage(Executors.newFixedThreadPool(10));
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder("Fibonacci sequence " + n + ": ");
        for (int i = 0; i < n; i++) {
            sb.append(fib(next()));
            if (i != n - 1) {
                sb.append(", ");
            }
        }

        System.out.println(sb.toString());
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }

    private static void manualThreadMenage() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Fibonacci(i)).start();
        }
    }

    private static void serviceThreadMenage(ExecutorService executor) {
        for (int i = 0; i < 10; i++) {
            executor.execute(new Fibonacci(i));
        }

        executor.shutdown();
    }

}
