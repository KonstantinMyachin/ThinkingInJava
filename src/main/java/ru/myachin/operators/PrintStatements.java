package ru.myachin.operators;

/**
 * 1. Напишите программу, в которой используются как "короткие", так и "длинные" команды печати.
 */
public class PrintStatements {

    public static void main(String[] args) {
        System.out.println("Длинная команда печати.");
        print("Короткая команда печати.");
    }

    static void print(String s) {
        System.out.println(s);
    }
}