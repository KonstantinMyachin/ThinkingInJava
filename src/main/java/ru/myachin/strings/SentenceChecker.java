package ru.myachin.strings;

/**
 * 7. Взяв за основу документацию {@link java.util.regex.Pattern}, напишите и протестируйте регулярное выражение,
 * которое проверяет, что предложение начинается с прописной буквы и завершается точкой.
 */
public class SentenceChecker {


    public static boolean check(final String s) {
        return s.matches("\\p{javaUpperCase}.*\\.$");
    }

    public static void main(String[] args) {
        System.out.println(check("This is a sentence."));
        System.out.println(check("This is a sentence"));
        System.out.println(check("This is a sentence..."));
        System.out.println(check("This is a sentence.."));
    }
}
