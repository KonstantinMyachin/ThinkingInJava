package ru.myachin.generics;

/**
 * 25. Создайте два интерфейса и класс, реализующий оба интерфейса. Создайте два обобщенных метода: у одного
 * параметр-тип ограничивается первым интерфейсом, а у другого - вторым интерфейсом. Создайте экземпляр класса,
 * который реализует оба интерфейса, и покажите, что он может использоваться с обоими обобщенными методами.
 */
public class Bounds implements FirstInterface, SecondInterface {

    public static void main(String[] args) {
        final Bounds bounds = new Bounds();
        someGenericMethod(bounds);
        anotherGenericMethod(bounds);
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething()");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("doSomethingElse()");
    }

    public static <T extends FirstInterface> void someGenericMethod(T iFace) {
        iFace.doSomething();
    }

    public static <T extends SecondInterface> void anotherGenericMethod(T iFace) {
        iFace.doSomethingElse();
    }
}

interface FirstInterface {

    void doSomething();
}

interface SecondInterface {

    void doSomethingElse();
}
