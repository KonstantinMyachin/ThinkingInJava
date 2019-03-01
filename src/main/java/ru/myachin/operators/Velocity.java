package ru.myachin.operators;

/**
 * 4. Напишите программу, которая вычисляет скорость для постоянных значений расстояния и времени.
 */
public class Velocity {

    public static void main(String[] args) {
        System.out.println(calculateVelocity(120, 2));
        System.out.println(calculateVelocity(30, 4));
        System.out.println(calculateVelocity(30, 4));
    }

    static double calculateVelocity(final double distance, final double time) {
        return distance / time;
    }
}