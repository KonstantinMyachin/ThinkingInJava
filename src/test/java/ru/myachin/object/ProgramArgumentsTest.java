package ru.myachin.object;

import org.junit.Test;

public class ProgramArgumentsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalProgramArguments() {
        ProgramArguments.main(new String[2]);
    }
}