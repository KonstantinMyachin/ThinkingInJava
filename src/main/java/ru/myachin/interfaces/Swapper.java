package ru.myachin.interfaces;

import ru.myachin.interfaces.interfaceprocessor.Apply;
import ru.myachin.interfaces.interfaceprocessor.Processor;

/**
 * 11. Создайте класс с методом, который получает аргумент {@link String} и переставляет местами кажду пару символов
 * в полученной строке. Адаптируйте класс так, чтобы он работал с
 * {@link ru.myachin.interfaces.interfaceprocessor.Apply#process(Processor, Object)}
 */
public class Swapper {

    public static void main(String[] args) {
        Apply.process(new SwapperAdapter(), "молоко");
        Apply.process(new SwapperAdapter(), "корова");
    }
}

class CharacterPairSwapper {

    public static String swap(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, n = chars.length; i < n - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }

        return new String(chars);
    }
}

class SwapperAdapter implements Processor {

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        return CharacterPairSwapper.swap((String) input);
    }
}