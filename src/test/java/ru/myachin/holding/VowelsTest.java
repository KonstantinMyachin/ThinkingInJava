package ru.myachin.holding;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class VowelsTest {

    @Test
    public void testVowelsInWord() {
        assertEquals(3, Vowels.vowelsInWord("Мамуля"));
        assertEquals(7, Vowels.vowelsInWord("Программирование"));
    }

    @Test
    public void testVowelsInFile() {
        assertEquals(19, Vowels.vowelsInFile("src\\test\\java\\ru\\myachin\\holding\\VowelsTest.java"));
    }

    @Test
    public void testVowelsMap() {
        Map<Character, Integer> vowelsMap = Vowels.vowelsCountMap("Мамуля");
        assertEquals(Integer.valueOf(1), vowelsMap.get('а'));
        assertEquals(Integer.valueOf(1), vowelsMap.get('у'));
        assertEquals(Integer.valueOf(1), vowelsMap.get('я'));
    }

    @Test
    public void testVowelsMapFromFile() {
        Map<Character, Integer> vowelsMap =
                Vowels.vowelsCountMapFromFile("src\\test\\java\\ru\\myachin\\holding\\VowelsTest.java");
        assertEquals(Integer.valueOf(6), vowelsMap.get('а'));
        assertEquals(Integer.valueOf(4), vowelsMap.get('у'));
        assertEquals(Integer.valueOf(4), vowelsMap.get('я'));
    }
}