package ru.myachin.object;

/**
 * 10. Напишите программу, которая выводит три параметра командной строки. Для получения аргументов вам потребуется
 * обращение к элементам массива строк (String).
 */
public class ProgramArguments {

    public static void main(String[] args) {
        if (args.length == 3) {
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
        } else {
            throw new IllegalArgumentException("Программа должна запускаться с тремя параметрами.");
        }
    }
}