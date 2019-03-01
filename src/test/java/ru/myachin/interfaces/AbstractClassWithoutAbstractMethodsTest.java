package ru.myachin.interfaces;

import org.junit.Test;

public class AbstractClassWithoutAbstractMethodsTest {

    @Test(expected = InstantiationException.class)
    public void testCreateAbstractClassInstance()
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("ru.myachin.interfaces.AbstractClassWithoutAbstractMethods");
        clazz.newInstance();
    }
}