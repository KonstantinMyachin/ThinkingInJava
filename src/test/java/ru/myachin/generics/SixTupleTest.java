package ru.myachin.generics;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SixTupleTest {

    @Test
    public void testToString() {
        int i = 0;
        final SixTuple<Integer, Integer, Integer, String, String, String> tuple =
                new SixTuple<>(i, ++i, ++i, "a", "b", "c");
        assertEquals("(0, 1, 2, a, b, c)", tuple.toString());
    }
}