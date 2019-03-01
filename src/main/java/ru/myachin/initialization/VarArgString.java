package ru.myachin.initialization;

/**
 * 19. Напишите метод, получающий список аргументов переменной длины с массиовм {@link String}. Убедитесь в том, что
 * этому методу может передаваться как сипоск объектов {@link String}, разделенных запятыми, так и <b>String[]</b>.
 */
public class VarArgString {

    static void printStrings(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        printStrings("One", "Two", "Three");
        printStrings(new String[]{"First element", "Second element", "Third element"});
    }
}