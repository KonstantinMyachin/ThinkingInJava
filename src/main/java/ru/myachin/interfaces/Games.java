package ru.myachin.interfaces;

import java.util.Random;

interface Game {

    Random RANDOM = new Random();

    void play();
}


interface GameFactory {

    Game newGame();
}

/**
 * 19. Создайте на базе паттерна "Фабричный метод" программную среду, моделирующую броки монет и броки кубиков.
 */
public class Games {

    static void demonstrate(GameFactory factory) {
        Game game = factory.newGame();
        for (int i = 0; i < 10; i++) {
            game.play();
        }
    }

    public static void main(String[] args) {
        System.out.println("Броски монет:");
        demonstrate(new CoinFlippingFactory());
        System.out.println("Броски кубика:");
        demonstrate(new DiceFactory());
    }
}

class CoinFlipping implements Game {

    @Override
    public void play() {
        System.out.println(RANDOM.nextBoolean() ? "Орел" : "Решка");
    }
}

class Dice implements Game {

    @Override
    public void play() {
        System.out.println(RANDOM.nextInt(6) + 1);
    }
}

class CoinFlippingFactory implements GameFactory {

    @Override
    public Game newGame() {
        return new CoinFlipping();
    }
}

class DiceFactory implements GameFactory {

    @Override
    public Game newGame() {
        return new Dice();
    }
}