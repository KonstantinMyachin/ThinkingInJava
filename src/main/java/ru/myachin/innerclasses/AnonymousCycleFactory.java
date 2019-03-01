package ru.myachin.innerclasses;

import ru.myachin.polymorphism.Bicycle;
import ru.myachin.polymorphism.Cycle;
import ru.myachin.polymorphism.Tricycle;
import ru.myachin.polymorphism.Unicycle;

interface CycleFactory {
    Cycle createCycle();
}

/**
 * 16. Измените {@link ru.myachin.interfaces.Cycles урпажнение 18 из главы 9} так, чтобы в нем использовались анонимные
 * внутренние классы.
 */
public class AnonymousCycleFactory {

    private static void wheels(CycleFactory cycleFactory) {
        System.out.println(cycleFactory.createCycle().wheels());
    }

    public static void main(String[] args) {
        CycleFactory uniCycleFactory = new CycleFactory() {
            @Override
            public Cycle createCycle() {
                return new Unicycle();
            }
        };

        CycleFactory biCycleFactory = new CycleFactory() {
            @Override
            public Cycle createCycle() {
                return new Bicycle();
            }
        };

        CycleFactory triCycleFactory = new CycleFactory() {
            @Override
            public Cycle createCycle() {
                return new Tricycle();
            }
        };

        wheels(uniCycleFactory);
        wheels(biCycleFactory);
        wheels(triCycleFactory);
    }
}