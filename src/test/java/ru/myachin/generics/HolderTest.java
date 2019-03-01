package ru.myachin.generics;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HolderTest {

    private Holder<String> holder = new Holder<>("First", "Second", "Third");

    @Test
    public void testGetFirst() {
        assertEquals(holder.getFirst(),"First");
        assertSame(holder.getFirst(),"First");
    }

    @Test
    public void testSetFirst() {
        holder.setFirst("A");
        assertEquals(holder.getFirst(),"A");
        assertSame(holder.getFirst(),"A");
    }

    @Test
    public void testGetSecond() {
        assertEquals(holder.getSecond(),"Second");
        assertSame(holder.getSecond(),"Second");
    }

    @Test
    public void testSetSecond() {
        holder.setSecond("B");
        assertEquals(holder.getSecond(),"B");
        assertSame(holder.getSecond(),"B");
    }

    @Test
    public void testGetThird() {
        assertEquals(holder.getThird(),"Third");
        assertSame(holder.getThird(),"Third");
    }

    @Test
    public void testSetThird() {
        holder.setThird("C");
        assertEquals(holder.getThird(),"C");
        assertSame(holder.getThird(),"C");
    }
}