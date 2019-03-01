package ru.myachin.containers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SimpleHashSetTest {

    SimpleHashSet<String> strings = new SimpleHashSet<>();

    @BeforeMethod
    public void setUp() {
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
    }

    @Test
    public void testGettingSize() {
        assertSame(4, strings.size());
    }

    @Test
    public void testClear() {
        strings.clear();
        assertSame(0, strings.size());
    }

    @Test
    public void testAdding() {
        assertFalse(strings.add("A"));
        assertTrue(strings.add("E"));
        assertSame(5, strings.size());
    }

    @Test
    public void remove() {
        assertTrue(strings.remove("A"));
        assertFalse(strings.remove("E"));
        assertSame(3, strings.size());
    }

    @Test
    public void testEmpty() {
        assertFalse(strings.isEmpty());
        strings.clear();
        assertTrue(strings.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(strings.contains("A"));
        assertTrue(strings.contains("B"));
        assertFalse(strings.contains("E"));
    }
}