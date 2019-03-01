package ru.myachin.holding;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluatorTest {

    @Test
    public void testEvaluation() throws Exception {
        assertEquals("cnUtreaiytn ursel", Evaluator.evaluate(Evaluator.INPUT));
    }

}