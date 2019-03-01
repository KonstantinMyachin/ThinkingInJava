package ru.myachin.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testGettingHelloWorld() {
        assertTrue("Hello, World!" == HelloWorld.HELLO_WORLD);
    }
}