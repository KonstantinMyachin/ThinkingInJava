package ru.myachin.innerclasses;

import org.junit.Test;

public class BTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidArrayLength() {
        new B(-1);
    }

    @Test(expected = RuntimeException.class)
    public void testOverFlow() {
        int count = 3;
        A a = new A();
        B b = new B(count);
        for (int i = 0; i <= count; i++) {
            b.add(a.getUInstance());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testRepeatableReset() {
        B b = new B(3);
        b.resetItem(0);
    }
}