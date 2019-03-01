package ru.myachin.interfaces;

/**
 * 1. Измените {@link ru.myachin.polymorphism.Rodents упражнение 9 из предыдущей главы} так, чтобы класс
 * {@link ru.myachin.polymorphism.Rodent} стал абстрактным <b>(abstract)</b> классом. Сделайте некоторые методы класса
 * {@link ru.myachin.polymorphism.Rodent} абстрактными (там, где это оправданно)
 */
public class AbstractRodent {

    public static void main(String[] args) {
        Rodent[] rodents = {
                new Mouse(),
                new Hamster(),
                new Gerbil()
        };

        for (Rodent rodent : rodents) {
            rodent.doSomething();
            rodent.reproduce();
        }
    }
}

abstract class Rodent {

    public abstract void doSomething();

    public abstract void reproduce();
}

class Mouse extends Rodent {

    @Override
    public void doSomething() {
        System.out.println("Mouse doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Mouse reproduce()");
    }
}

class Hamster extends Rodent {

    @Override
    public void doSomething() {
        System.out.println("Hamster doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Hamster reproduce()");
    }
}

class Gerbil extends Rodent {

    @Override
    public void doSomething() {
        System.out.println("Gerbil doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Gerbil reproduce()");
    }
}