package ru.myachin.enumerated;

import java.util.Arrays;
import java.util.Random;

/**
 * 5. Измените пример <tt>control/VowelsAndConsonants.java</tt> так, чтобы в нем использовались три типа перечислений:
 * <tt>VOWEL</tt>, <tt>SOMETIMES_A_VOWEL</tt> и <tt>CONSONANT</tt>. Конструктор перечисления должен получать буквы,
 * описывающие эту конкретную категорию. Подсказка: Используйте списки аргументов переменной длины и помните, что
 * массив создается автоматически.
 */
public enum CharacterCategory {
    VOWEL('a', 'e', 'i', 'o', 'u') {
        @Override
        public String toString() {
            return "vowel";
        }
    },
    SOMETIMES_A_VOWEL('y', 'w') {
        @Override
        public String toString() {
            return "sometimes a vowel";
        }
    },
    CONSONANT {
        @Override
        public String toString() {
            return "consonant";
        }
    };

    private Character[] chars;

    CharacterCategory(Character... chars) {
        if (chars != null) {
            this.chars = chars;
        }
    }

    public static CharacterCategory getCharCategory(char c) {
        if (Arrays.asList(VOWEL.chars).contains(c)) {
            return VOWEL;
        } else if (Arrays.asList(SOMETIMES_A_VOWEL.chars).contains(c)) {
            return SOMETIMES_A_VOWEL;
        } else {
            return CONSONANT;
        }
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        for (int i = 0; i < 100; i++) {
            char c = (char) (rand.nextInt(26) + 'a');
            System.out.println(c + ": " + getCharCategory(c));
        }
    }
}