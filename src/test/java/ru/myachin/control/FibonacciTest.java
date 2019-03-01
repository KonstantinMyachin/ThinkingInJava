package ru.myachin.control;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testFibonacciSequence() {
        assertEquals(Fibonacci.getFibonacci(5), "1, 1, 2, 3, 5");
        assertEquals(Fibonacci.getFibonacci(6), "1, 1, 2, 3, 5, 8");
        assertEquals(Fibonacci.getFibonacci(7), "1, 1, 2, 3, 5, 8, 13");
        assertEquals(Fibonacci.getFibonacci(8), "1, 1, 2, 3, 5, 8, 13, 21");
        assertEquals(Fibonacci.getFibonacci(9), "1, 1, 2, 3, 5, 8, 13, 21, 34");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalFibonacciNumber() {
        Fibonacci.getFibonacci(-1);
    }
}