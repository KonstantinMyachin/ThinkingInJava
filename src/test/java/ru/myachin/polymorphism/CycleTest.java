package ru.myachin.polymorphism;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CycleTest {

    private Cycle[] cycles;

    @Before
    public void setUp() throws Exception {
        cycles = new Cycle[4];
        cycles[0] = new Cycle();
        cycles[1] = new Unicycle();
        cycles[2] = new Bicycle();
        cycles[3] = new Tricycle();
    }

    @Test(expected = ClassCastException.class)
    public void testFailDownCast() {
        ((Unicycle) cycles[0]).balance();
        ((Unicycle) cycles[3]).balance();
    }

    @Test
    public void testDownCast() {
        assertTrue(cycles[1] instanceof Unicycle);
        assertTrue(cycles[2] instanceof Bicycle);
        assertTrue(cycles[3] instanceof Tricycle);
    }

    @Test
    public void testGettingWheels() {
        for (int i = 0, n = cycles.length; i < n; i++) {
            assertEquals(i, cycles[i].wheels());
        }
    }
}