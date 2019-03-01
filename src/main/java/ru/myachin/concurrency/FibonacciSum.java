package ru.myachin.concurrency;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 5. Измените упражнение 2, чтобы задача была представлена объектом {@link Callable} для суммирования всех чисел
 * Фибоначчи. Создайте несколько задач и выведите результаты.
 * <p>
 */
public class FibonacciSum implements Generator<Integer>, Callable<Integer> {

    private int counter;
    private final int n;

    public FibonacciSum(int n) {
        this.n = n;
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public Integer next() {
        return fib(counter++);
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += next();
        }

        return sum;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>(5);
        for (int i = 1; i < 10; i++) {
            results.add(executor.submit(new FibonacciSum(i)));
        }

        executor.shutdown();
        for (Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
