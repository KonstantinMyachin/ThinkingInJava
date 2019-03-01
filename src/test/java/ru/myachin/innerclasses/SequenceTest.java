package ru.myachin.innerclasses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest {

    private Sequence sequence;
    private int count;

    @Before
    public void setUp() throws Exception {
        count = 5;
        sequence = new Sequence(count);
        for (int i = 0; i < 5; i++) {
            sequence.add(i);
        }
    }

    @Test
    public void testRightSequence() {
        Selector selector = sequence.selector();
        for (int i = 0; i < count; i++) {
            assertEquals(i, selector.current());
            selector.next();
        }
    }

    @Test
    public void testReverseSequence() {
        Selector selector = sequence.reverseSelector();
        for (int i = count - 1; i >= 0; i--) {
            assertEquals(i, selector.current());
            selector.next();
        }
    }
}