package ru.myachin.operators;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnsignedRightShiftTest {

    @DataProvider(name = "dataForCompareResult")
    public Object[][] dataProvider() {
        return new Object[][] {
                {0b11111111111111111111111111111111, 0b01111111111111111111111111111111},
                {0b01111111111111111111111111111111, 0b00111111111111111111111111111111},
                {0b00111111111111111111111111111111, 0b00011111111111111111111111111111},
                {0b00011111111111111111111111111111, 0b00001111111111111111111111111111},
                {0b00001111111111111111111111111111, 0b00000111111111111111111111111111},
                {0b00000111111111111111111111111111, 0b00000011111111111111111111111111},
                {0b00000011111111111111111111111111, 0b00000001111111111111111111111111},
                {0b00000001111111111111111111111111, 0b00000000111111111111111111111111},
        };
    }


    @Test(dataProvider = "dataForCompareResult")
    public void testRightShift(int i, int result) throws Exception {
        assertTrue(UnsignedRightShift.rightShift(i) == result);
    }
}