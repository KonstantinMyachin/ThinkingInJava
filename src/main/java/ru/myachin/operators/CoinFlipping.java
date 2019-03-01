package ru.myachin.operators;

import java.util.Random;

/**
 * 7. Напишите программу, моделирующую бросок монетки.
 */
public class CoinFlipping {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(flipTheCoin());
        }
    }

    private static String flipTheCoin() {
        Random random = new Random();
        return random.nextBoolean() ? "Орел" : "Решка";
    }
}