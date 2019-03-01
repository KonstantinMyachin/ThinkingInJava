package ru.myachin.generics;

import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.*;

public class ClassTypeCaptureTest {

    @Test
    public void testAddingType() {
        final ClassTypeCapture capture = new ClassTypeCapture();
        capture.addType("String", String.class);
        final Map<String, Class<?>> map = capture.getMap();
        assertEquals(1, map.size());
        assertSame(String.class, map.get("String"));
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testCreatingNewUnknownType() {
        final ClassTypeCapture capture = new ClassTypeCapture();
        capture.createNew("Unknown");
    }

    @Test
    public void testCreatingNew() {
        final ClassTypeCapture capture = new ClassTypeCapture();
        capture.addType("String", String.class);
        final Object obj = capture.createNew("String");
        assertTrue(obj instanceof String);
    }
}