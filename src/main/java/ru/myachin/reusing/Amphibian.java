package ru.myachin.reusing;

/**
 * 16. Создайте класс с именем <b>Amphibian</b>. Объявите производный от него класс с именем <b>Frog</b>. Разместите в
 * базовом классе несколько методов. В методе {@link #main(String[])} создайте объект <b>Frog</b>, преобразуйте его в
 * <b>Amphibian</b> и продемонстрируйте, что все методы работают.
 * <p>
 * 17. Измените упражнение 16 так, чтобы класс {@link Frog} переопределял методы базового класса (предоставляя новые
 * определения с той же сигнатурой метода). Посмотрите, что произойдет в методе {@link #main(String[])}.
 */
public class Amphibian {

    public static void main(String[] args) {
        Amphibian frog = new Frog();
        frog.jump();
        frog.doSomething();
    }

    void jump() {
        System.out.println("Amphibian jump()");
    }

    void doSomething() {
        System.out.println("Amphibian doSomething()");
    }
}

class Frog extends Amphibian {

    @Override
    void jump() {
        System.out.println("Frog jump()");
    }

    @Override
    void doSomething() {
        System.out.println("Frog doSomething()");
    }
}