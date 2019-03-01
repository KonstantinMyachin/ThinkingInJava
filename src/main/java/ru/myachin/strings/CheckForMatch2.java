package ru.myachin.strings;

/**
 * 11. Примените регулярное выаражение <tt>(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b</tt> к строке
 * <tt>"Airline ate eight apples and one orange while Anita hadn't any"</tt>
 */
public class CheckForMatch2 {

    public static void main(String[] args) {
        String regEx = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        System.out.println("Airline ate eight apples and one orange while Anita hadn't any.".matches(regEx));
    }
}
