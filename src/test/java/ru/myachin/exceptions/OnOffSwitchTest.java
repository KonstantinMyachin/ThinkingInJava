package ru.myachin.exceptions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnOffSwitchTest {

    @Test
    public void testIncorrectSwitchState() {
        OnOffSwitch.main(new String[]{});
        assertEquals("вкл", OnOffSwitch.sw.toString());
    }
}