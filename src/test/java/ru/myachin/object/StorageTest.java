package ru.myachin.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class StorageTest {

    @Test
    public void testStaticStorage() {
        Storage storage = new Storage();
        assertEquals(storage.storage(Storage.S), 8);
    }
}