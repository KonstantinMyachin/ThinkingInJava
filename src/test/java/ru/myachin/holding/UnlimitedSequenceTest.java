package ru.myachin.holding;

import org.junit.Test;
import ru.myachin.innerclasses.Selector;

import static org.junit.Assert.*;

public class UnlimitedSequenceTest {


    @Test
    public void testRightSequence() {
        UnlimitedSequence sequence = new UnlimitedSequence();
        int count = 5;
        for (int i = 0; i < count; i++) {
            sequence.add(i);
        }

        Selector selector = sequence.selector();
        for (int i = 0; i < count; i++) {
            assertEquals(i, selector.current());
            selector.next();
        }
    }
}