package ru.myachin.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncrementableTest {

    @Test
    public void testIncrement() {
        int i = StaticTest.i;
        Incrementable.increment();
        assertTrue(StaticTest.i == (i + 1));
    }

}