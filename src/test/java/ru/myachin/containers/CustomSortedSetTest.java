package ru.myachin.containers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CustomSortedSetTest {

    private CustomSortedSet<String> sortedSet = new CustomSortedSet<>();;

    @BeforeMethod
    public void setUp() {
        sortedSet.add("Z");
        sortedSet.add("F");
        sortedSet.add("C");
        sortedSet.add("A");
        sortedSet.add("K");
    }

    @Test
    public void testFirst() {
        Assert.assertSame("A", sortedSet.first());
    }

    @Test
    public void testLast() {
        Assert.assertSame("Z", sortedSet.last());
    }

    @Test
    public void testSize() {
        Assert.assertSame(5, sortedSet.size());
        sortedSet.add("N");
        Assert.assertSame(6, sortedSet.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(sortedSet.isEmpty());
        sortedSet.clear();
        Assert.assertTrue(sortedSet.isEmpty());
    }

    @Test
    public void testContains() {
        Assert.assertTrue(sortedSet.contains("A"));
        Assert.assertTrue(sortedSet.contains("C"));
        Assert.assertFalse(sortedSet.contains("B"));
    }

    @Test
    public void testClear() {
        sortedSet.clear();
        Assert.assertTrue(sortedSet.isEmpty());
    }

    @Test
    public void testRemove() {
        sortedSet.remove("A");
        Assert.assertSame(4, sortedSet.size());
        sortedSet.remove("C");
        Assert.assertSame(3, sortedSet.size());
    }

    @Test
    public void testContainsAll() {
        Assert.assertTrue(sortedSet.containsAll(Arrays.asList("A", "C")));
        Assert.assertFalse(sortedSet.containsAll(Arrays.asList("A", "B")));
    }

    @Test
    public void testRetainAll() {
        sortedSet.retainAll(Arrays.asList("A", "0", "a", "d"));
        Assert.assertSame(1, sortedSet.size());
    }
}