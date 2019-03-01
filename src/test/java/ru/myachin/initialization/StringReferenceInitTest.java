package ru.myachin.initialization;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringReferenceInitTest {

    @Test
    public void tesNullReference() {
        assertNull(new StringReferenceInit().s);
    }
}