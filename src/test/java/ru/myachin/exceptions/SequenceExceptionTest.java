package ru.myachin.exceptions;

import org.junit.Test;

public class SequenceExceptionTest {

    @Test(expected = SequenceFullException.class)
    public void testFulledSequence() throws Exception {
        SequenceException sequence = new SequenceException(5);
        for (int i = 0; i <= 5; i++) {
            sequence.add(i);
        }
    }
}