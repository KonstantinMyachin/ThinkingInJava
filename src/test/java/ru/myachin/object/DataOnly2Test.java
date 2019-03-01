package ru.myachin.object;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataOnly2Test {

    @Test
    public void testDataEquality() {
        DataOnly2 dataOnly2 = new DataOnly2();
        assertTrue(dataOnly2.i == 5);
        assertTrue(dataOnly2.d == 5.5);
        assertTrue(dataOnly2.b == true);
    }
}