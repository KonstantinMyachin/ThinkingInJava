package ru.myachin.strings;

import java.util.Formatter;

/**
 * 10. Определите, будет ли найдено в строке <tt>"Java now has regular expressions"</tt> совпадение для
 * следующих выражений:
 * <ul>
 *     <li>^Java</li>
 *     <li>\Breg.*</li>
 *     <li>n.w\s+h(a|i)s</li>
 *     <li>s?</li>
 *     <li>s+</li>
 *     <li>s{4}</li>
 *     <li>s{1}</li>
 *     <li>s(0,3)</li>
 * </ul>
 */
public class CheckForMatch {

    public static void main(String[] args) {
        String s = "Java now has regular expressions";
        String[] regExs = {
                "^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s{4}", "s{1}", "s(0,3)"
        };

        Formatter formatter = new Formatter(System.out);
        for (String regEx : regExs) {
            formatter.format("Matches? %b. Regular expression = %s%n", s.matches(regEx), regEx);
        }
    }
}