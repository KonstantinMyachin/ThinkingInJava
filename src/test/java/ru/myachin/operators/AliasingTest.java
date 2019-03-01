package ru.myachin.operators;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AliasingTest {

    @Test
    public void testAliasing() {
        Aliasing aliasing1 = new Aliasing();
        Aliasing aliasing2 = new Aliasing();
        aliasing1 = aliasing2;

        assertTrue(aliasing1.f == aliasing2.f);

        Random random = new Random();
        aliasing1.f = random.nextFloat();

        assertTrue(aliasing1.f == aliasing2.f);
    }
}