package ru.myachin.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultInitializationTest {

    @Test
    public void testDefaultInitialization() {
        DefaultInitialization df = new DefaultInitialization();
        assertTrue(df.i == 0);
        assertTrue(df.c == '\u0000');
    }
}