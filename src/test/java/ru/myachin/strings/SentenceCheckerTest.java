package ru.myachin.strings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SentenceCheckerTest {

    @DataProvider(name = "isNotSentences")
    public Object[] isNotSentence() {
        return new Object[]{
                "it is Not Sentence",
                "sentence.",
                "Sentence",
                "this Is a Sentence."
        };
    }

    @Test(dataProvider = "isNotSentences")
    public void testUncheck(final String s) {
        assertFalse(SentenceChecker.check(s));
    }

    @DataProvider(name = "isSentences")
    public Object[] isSentence() {
        return new Object[]{
                "This is a sentence.",
                "Another sentence.",
                "One more sentence.",
                "Too much sentences."
        };
    }

    @Test(dataProvider = "isSentences")
    public void testCheck(final String s) {
        assertTrue(SentenceChecker.check(s));
    }
}