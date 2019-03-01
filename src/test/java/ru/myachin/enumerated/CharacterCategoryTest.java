package ru.myachin.enumerated;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharacterCategoryTest {

    @Test
    public void testGetCharCategory() {
        assertSame(CharacterCategory.getCharCategory('a'), CharacterCategory.VOWEL);
        assertSame(CharacterCategory.getCharCategory('y'), CharacterCategory.SOMETIMES_A_VOWEL);
        assertSame(CharacterCategory.getCharCategory('b'), CharacterCategory.CONSONANT);
    }
}