package ru.myachin.control;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VampireTest {

    @DataProvider
    public Object[][] inputData() {
        return new Object[][]{
                {1260, true},
                {1261, false},
                {1395, true},
                {1396, false},
                {1435, true},
                {1436, false},
                {1530, true},
                {1531, false},
                {1827, true},
                {1828, false},
                {2187, true},
                {2188, false},
                {6880, true},
                {6881, false},
        };
    }

    @Test(dataProvider = "inputData")
    public void testVampireNumbers(int i, boolean isVampire) {
        assertEquals(Vampire.isVampire(i), isVampire);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalNumber() {
        Vampire.isVampire(999);
    }
}