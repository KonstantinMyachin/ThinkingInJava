package ru.myachin.generics;

import net.mindview.generics.Fibonacci;

import java.util.Iterator;

/**
 * 7. Используйте композицию вместо наследования при адаптации {@link Fibonacci} к {@link Iterable}
 */
public class IterableFibonacci implements Iterable<Integer> {

    private Fibonacci fib = new Fibonacci();
    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    public static void main(String[] args) {
        for(int i : new IterableFibonacci(35)) {
            System.out.print(i + " ");
        }
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                --n;
                return fib.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
