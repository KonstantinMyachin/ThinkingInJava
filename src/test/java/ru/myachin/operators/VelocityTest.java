package ru.myachin.operators;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VelocityTest {

    @DataProvider(name = "DataForCalculation")
    public static Object[][] calculateInfo() {
        return new Object[][]{
                {120, 2, 60},
                {100, 5, 20},
                {30, 3, 10},
                {30, 60, 0.5}
        };
    }

    @Test(dataProvider = "DataForCalculation")
    public void testCalculateVelocity(double distance, double time, double result) {
        assertEquals(Velocity.calculateVelocity(distance, time), result);
    }

    @Test
    public void testDivisionByZero() {
        assertEquals(Velocity.calculateVelocity(120, 0), Double.POSITIVE_INFINITY);
    }

}