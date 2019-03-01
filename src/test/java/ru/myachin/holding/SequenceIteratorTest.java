package ru.myachin.holding;

import org.junit.Test;
import ru.myachin.innerclasses.Selector;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SequenceIteratorTest {

    @Test
    public void testRightSequence() {
        SequenceIterator sequence = new SequenceIterator();
        int count = 5;
        for (int i = 0; i < count; i++) {
            sequence.add(i);
        }

        Iterator selector = sequence.selector();
        for (int i = 0; i < count; i++) {
            assertEquals(i, selector.next());
        }
    }
}