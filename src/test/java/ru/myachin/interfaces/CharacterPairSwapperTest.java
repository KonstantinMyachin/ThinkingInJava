package ru.myachin.interfaces;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterPairSwapperTest {

    @Test
    public void testSwapCharacterPairInString() {
        assertEquals("омолок", CharacterPairSwapper.swap("молоко"));
        assertEquals("окорав", CharacterPairSwapper.swap("корова"));
        assertEquals("окамдна", CharacterPairSwapper.swap("команда"));
    }
}