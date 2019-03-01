package ru.myachin.interfaces;

interface CycleI {

    void run();
}

interface CycleFactory {

    CycleI createCycle();
}

/**
 * 18. Создайте интерфейс <b>CycleI</b> с реализациями <b>Unicycle, Bicycle, Tricycle</b>. Создайте фабрику для каждой
 * разновидности <b>CycleI</b> и код, используюзий эти фабрики.
 */
public class Cycles {

    public static void ride(CycleFactory cycleFactory) {
        cycleFactory.createCycle().run();
    }

    public static void main(String[] args) {
        ride(new UnicycleFactory());
        ride(new BicycleFactory());
        ride(new TricycleFactory());
    }
}

class Unicycle implements CycleI {

    @Override
    public void run() {
        System.out.println("Unicycle run()");
    }
}

class Bicycle implements CycleI {

    @Override
    public void run() {
        System.out.println("Bicycle run()");
    }
}

class Tricycle implements CycleI {

    @Override
    public void run() {
        System.out.println("Tricycle run()");
    }
}

class UnicycleFactory implements CycleFactory {

    @Override
    public CycleI createCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {

    @Override
    public CycleI createCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {

    @Override
    public CycleI createCycle() {
        return new Tricycle();
    }
}