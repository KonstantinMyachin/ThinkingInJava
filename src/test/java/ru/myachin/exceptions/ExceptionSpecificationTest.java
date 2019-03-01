package ru.myachin.exceptions;

import org.junit.Test;

public class ExceptionSpecificationTest {

    @Test(expected = OwnException.class)
    public void testThrowingException() throws OwnException {
        ExceptionSpecification.someMethod();
    }
}