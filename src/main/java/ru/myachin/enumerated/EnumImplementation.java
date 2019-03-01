package ru.myachin.enumerated;

import java.util.Random;

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private static Random rand = new Random(47);

    public static CartoonCharacter next() {
        CartoonCharacter[] values = values();
        return values[rand.nextInt(values.length)];
    }
}

/**
 * 2. Вместо того чтобы реализовать интерфейс, сделайте <tt>next()</tt> статическим методом. Какими преимуществами и
 * недостатками обладает данное решение?
 */
public class EnumImplementation {

    private static void printNext() {
        System.out.print(CartoonCharacter.next() + ", ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printNext();
        }
    }
}
