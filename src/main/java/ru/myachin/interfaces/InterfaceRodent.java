package ru.myachin.interfaces;

interface RodentInterface {

    void doSomething();

    void reproduce();
}

/**
 * 7. Измените {@link ru.myachin.polymorphism.Rodents упражнение 9 из главы 8} так, чтобы тип
 * {@link ru.myachin.polymorphism.Rodent} был оформлен как интерфейс.
 */
public class InterfaceRodent {

    public static void main(String[] args) {
        RodentInterface[] rodents = {
                new MouseImpl(),
                new HamsterImpl(),
                new GerbilImpl()
        };

        for (RodentInterface rodent : rodents) {
            rodent.doSomething();
            rodent.reproduce();
        }
    }
}

class MouseImpl implements RodentInterface {

    @Override
    public void doSomething() {
        System.out.println("Mouse doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Mouse reproduce()");
    }
}

class HamsterImpl implements RodentInterface {

    @Override
    public void doSomething() {
        System.out.println("Hamster doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Hamster reproduce()");
    }
}

class GerbilImpl implements RodentInterface {

    @Override
    public void doSomething() {
        System.out.println("Gerbil doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Gerbil reproduce()");
    }
}