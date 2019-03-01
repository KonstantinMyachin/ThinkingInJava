package ru.myachin.arrays;

import net.mindview.util.CountingGenerator;

/**
 * 13. Заполните объект {@link String} с использованим {@link CountingGenerator.Character}.
 */
public class GeneratingStringFromChars {

    public static void main(String[] args) {
        final CountingGenerator.Character charGenerator = new CountingGenerator.Character();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(charGenerator.next());
        }

        String s = sb.toString();
        System.out.println(s);
    }
}
