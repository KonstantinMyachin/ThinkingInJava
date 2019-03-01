package ru.myachin.exceptions;

import org.junit.Test;

public class ChangeExceptionTest {

    @Test(expected = SecondException.class)
    public void testChangeException() throws SecondException {
        ChangeException.f();
    }

    @Test(expected = RuntimeException.class)
    public void testChangeException2() {
        ChangeException2.f();
    }
}