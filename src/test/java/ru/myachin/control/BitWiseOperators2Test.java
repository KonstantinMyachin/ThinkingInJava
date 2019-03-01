package ru.myachin.control;

import org.junit.Test;
import ru.myachin.operators.BitWiseOperators;

import static org.junit.Assert.*;

public class BitWiseOperators2Test {

    @Test
    public void testGetBinaryString() throws Exception {
        assertEquals(addLPadZero(Integer.toBinaryString(BitWiseOperators.FIRST_INTEGER)),
                BitWiseOperators2.getBinaryString(BitWiseOperators.FIRST_INTEGER));
        assertEquals(addLPadZero(Integer.toBinaryString(BitWiseOperators.SECOND_INTEGER)),
                BitWiseOperators2.getBinaryString(BitWiseOperators.SECOND_INTEGER));
        assertEquals(addLPadZero(Integer.toBinaryString(~BitWiseOperators.FIRST_INTEGER)),
                BitWiseOperators2.getBinaryString(~BitWiseOperators.FIRST_INTEGER));
        assertEquals(addLPadZero(Integer.toBinaryString(~BitWiseOperators.SECOND_INTEGER)),
                BitWiseOperators2.getBinaryString(~BitWiseOperators.SECOND_INTEGER));
        assertEquals(addLPadZero(Integer.toBinaryString(BitWiseOperators.FIRST_INTEGER & BitWiseOperators.SECOND_INTEGER)),
                BitWiseOperators2.getBinaryString(BitWiseOperators.FIRST_INTEGER & BitWiseOperators.SECOND_INTEGER));
        assertEquals(addLPadZero(Integer.toBinaryString(BitWiseOperators.FIRST_INTEGER | BitWiseOperators.SECOND_INTEGER)),
                BitWiseOperators2.getBinaryString(BitWiseOperators.FIRST_INTEGER | BitWiseOperators.SECOND_INTEGER));
        assertEquals(addLPadZero(Integer.toBinaryString(BitWiseOperators.FIRST_INTEGER ^ BitWiseOperators.SECOND_INTEGER)),
                BitWiseOperators2.getBinaryString(BitWiseOperators.FIRST_INTEGER ^ BitWiseOperators.SECOND_INTEGER));
    }

    private String addLPadZero(String s) {
        return String.format("%32s", s).replace(' ', '0');
    }
}