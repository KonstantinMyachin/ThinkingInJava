package ru.myachin.holding;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordsInfoTest {

    @Test
    public void testWordCountMap() {
        Map<String, Integer> countMap =
                WordsInfo.wordsCountMap("src\\test\\java\\ru\\myachin\\holding\\WordsInfoTest.java");
        assertEquals(Integer.valueOf(3), countMap.get("myachin"));
        assertEquals(Integer.valueOf(3), countMap.get("WordsInfoTest"));
        assertEquals(Integer.valueOf(3), countMap.get("public"));
    }
}