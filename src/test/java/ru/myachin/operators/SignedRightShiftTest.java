package ru.myachin.operators;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SignedRightShiftTest {

    @DataProvider(name = "dataForCompareResult")
    public Object[][] dataProvider() {
            return new Object[][] {
                {0b10000000000000000000000000000000, 0b11000000000000000000000000000000},
                {0b11000000000000000000000000000000, 0b11100000000000000000000000000000},
                {0b11100000000000000000000000000000, 0b11110000000000000000000000000000},
                {0b11110000000000000000000000000000, 0b11111000000000000000000000000000},
                {0b11111000000000000000000000000000, 0b11111100000000000000000000000000},
                {0b11111100000000000000000000000000, 0b11111110000000000000000000000000},
                {0b11111110000000000000000000000000, 0b11111111000000000000000000000000},
            };
    }

    @Test(dataProvider = "dataForCompareResult")
    public void testRightShift(int i, int result) throws Exception {
        assertTrue(SignedRightShift.rightShift(i) == result);
    }

}