package ru.myachin.reusing;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class FinalFieldsTest {

    private int n;

    @BeforeTest
    public void setUp() {
        Random random = new Random();
        n = random.nextInt();
    }

    @Test
    public void tesCounter() {
        for (int i = 1; i < n; i++) {
            FinalFields finalFields = new FinalFields();
            assertEquals(i, finalFields.getId());
        }
    }

}