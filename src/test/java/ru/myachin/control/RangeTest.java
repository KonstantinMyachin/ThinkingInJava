package ru.myachin.control;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RangeTest {

    @DataProvider
    public Object[][] inputData() {
        return new Object[][] {
                {0, -1, 1, true},
                {0, 1, 2, false},
                {0, 0, 0, true},
                {0, 0, 1, true},
                {1, 0, 1, true},
        };
    }

    @Test(dataProvider = "inputData")
    public void testContains(int testValue, int begin, int end, boolean contains) {
        assertEquals(Range.test(testValue, begin, end), contains);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalRangeArgument() {
        Range.test(0, 10, 5);
    }
}