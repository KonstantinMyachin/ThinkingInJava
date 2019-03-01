package ru.myachin.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataOnlyTest {

    @Test
    public void testDataEquality() {
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 47;
        dataOnly.d = 1.1;
        dataOnly.b = false;

       assertTrue(dataOnly.i == 47);
       assertTrue(dataOnly.d == 1.1);
       assertTrue(dataOnly.b == false);
    }
}