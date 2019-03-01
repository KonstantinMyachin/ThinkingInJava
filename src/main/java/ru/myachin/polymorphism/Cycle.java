package ru.myachin.polymorphism;

/**
 * 1. Создайте класс <b>Cycle</b> с производными классами <b>Unicycle, Bicycle, Tricycle</b>. Покажите, что экземпляр
 * каждого из производных типов может быть преобразов в <b>Cycle</b>, на примере вызова метода <b>ride()</b>;
 * <p>
 * 5. В {@link Cycle упражнении 1} добавьте в класс <b>Cycle</b> метод <b>wheels()</b>, возвращающий количество колес
 * каждого транспортного средства. Измените метод {@link #ride(Cycle)} так, чтобы он вызывал метод <b>wheels()</b>, и
 * убедитесь в том, что полиморфизм успешно работает.
 * <p>
 * 18. Используя иерархию {@link Cycle} из упражнения 1, включите метод <b>balance()</b> в классы {@link Unicycle} и
 * {@link Bicycle}, но не в {@link Tricycle}. Создайте экземпляры всех трех типов и выполните их восходящее
 * преобразование в массив {@link Cycle}. Попробйуте вызвать метод <b>balance()</b> для каждого элемента массива.
 * Теперь выполните нисходящее преобразование, вызовите <b>balance()</b> и проанлизируйте результат.
 */
public class Cycle {

    static void ride(Cycle cycle) {
        System.out.println(cycle.getClass().getSimpleName() + " has " + cycle.wheels() + " wheels.");
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        ride(cycle);
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);

        Cycle[] cycles = {
                cycle, unicycle, bicycle, tricycle
        };

        for (Cycle c : cycles) {
//            c.balance(); compiler error
        }

//        ((Unicycle) cycles[0]).balance(); ClassCastException
        ((Unicycle) cycles[1]).balance();
        ((Bicycle) cycles[2]).balance();
//        ((Unicycle) cycles[3]).balance(); ClassCastException
    }

    public int wheels() {
        return 0;
    }
}