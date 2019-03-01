package ru.myachin.strings;

import java.util.Arrays;

/**
 * 14. Перепишите класс {@link net.mindview.strings.SplitDemo} с использованием String.split().
 */
public class SplitDemo2 {

    public static void main(String[] args) {
        String input = "This!!unusual use !!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
        System.out.println(Arrays.toString(input.split("!!", 3)));
    }
}