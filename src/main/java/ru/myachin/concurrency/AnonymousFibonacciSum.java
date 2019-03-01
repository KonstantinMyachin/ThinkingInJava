package ru.myachin.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 10. Измените {@link FibonacciSum упражнение 5} по образцу класса <tt>ThreadMethod</tt>, чтобы метод
 * <tt>runTask()</tt> получал аргумент с количеством суммируемых чисел Фибоначчи и при каждом вызове
 * <tt>runTask()</tt> возвращал объект {@link Future}, полученный при вызове {@link ExecutorService#submit(Runnable)}
 */
public class AnonymousFibonacciSum {

    public ExecutorService getExecutor() {
        return executor;
    }

    private ExecutorService executor;

    public Future<Integer> runTask(final int n) {
        if (executor == null) {
            executor = Executors.newCachedThreadPool();
        }

        return executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += fib(i);
                }

                return sum;
            }

            private int fib(int n) {
                if (n < 2) {
                    return 1;
                }

                return fib(n - 2) + fib(n - 1);
            }
        });
    }

    public static void main(String[] args) {
        AnonymousFibonacciSum fibonacciSum = new AnonymousFibonacciSum();
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            results.add(fibonacciSum.runTask(i));
        }

        fibonacciSum.getExecutor().shutdown();

        for (Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
