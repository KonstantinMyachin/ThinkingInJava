package ru.myachin.reusing;

/**
 * 11. Измените пример {@link Detergent} так, чтобы в нем использовалось делегирование.
 */
public class DetergentDelegation {

    Cleanser cleanser = new Cleanser();

    public static void main(String[] args) {
        Cleanser.main(args);
    }

    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        cleanser.scrub();
    }

    @Override
    public String toString() {
        return cleanser.toString();
    }
}