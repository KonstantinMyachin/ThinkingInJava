package ru.myachin.exceptions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WIthFinallyTest {

    @Test
    public void testCorrectSwitchState() {
        WIthFinally.main(new String[]{});
        assertEquals("выкл", WIthFinally.sw.toString());
    }

}