package ru.myachin.strings;

/**
 * 9. Взяв за основу документацию {@link java.util.regex.Pattern}, замените все гласные в
 * {@link Splitting#knights} подчеркиваниями.
 */
public class ReplacingVowels {

    public static void main(String[] args) {
        String s = Splitting.knights.replaceAll("[aeiou]", "_");
        System.out.println(s);
    }
}