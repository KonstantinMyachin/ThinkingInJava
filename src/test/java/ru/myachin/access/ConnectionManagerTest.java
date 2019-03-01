package ru.myachin.access;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionManagerTest {

    @Test
    public void testGettingConnection() {
        assertNotNull(ConnectionManager.getConnection());
        assertNotNull(ConnectionManager.getConnection());
        assertNotNull(ConnectionManager.getConnection());
        assertNull(ConnectionManager.getConnection());
        assertNull(ConnectionManager.getConnection());
        assertNull(ConnectionManager.getConnection());
    }
}