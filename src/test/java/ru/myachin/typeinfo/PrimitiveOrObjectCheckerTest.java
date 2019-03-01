package ru.myachin.typeinfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrimitiveOrObjectCheckerTest {

    @DataProvider(name = "primitiveWrappers")
    public Object[] primitiveWrappers() {
        return new Object[] {
                new Boolean("true"), new Byte("0"), new Short("1"), new Character('C'),
                new Integer("1"), new Long("1"), new Float("1"), new Double("1")
        };
    }

    @Test(dataProvider = "primitiveWrappers")
    public void isNotPrimitive(final Object o) {
        assertFalse(PrimitiveOrObjectChecker.isPrimitive(o.getClass()));
    }


    @DataProvider(name = "primitives")
    public Object[] primitives() {
        return new Object[] {
                Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE,
                Void.TYPE
        };
    }

    @Test(dataProvider = "primitives")
    public void isPrimitive(final Class aClass) {
        assertTrue(PrimitiveOrObjectChecker.isPrimitive(aClass));
    }
}