package ru.myachin.generics;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InstantiateGenericTypeTest {

    @Test
    public void testCreatingInstance() {
        final InstantiateGenericType<Boolean> type = new InstantiateGenericType<>(Boolean.class);
        final Boolean b = type.create(true);
        assertTrue(b);
    }
}