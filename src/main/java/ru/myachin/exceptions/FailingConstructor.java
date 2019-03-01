package ru.myachin.exceptions;

/**
 * 22. Создайте класс <b>FailingConstructor</b> с конструктором, во время выполнения которого может произойти ошибка,
 * приводящая к выдаче исключения. В методе <b>main()</b> напишите код, который защищает программу от таких сбоев.
 * <p>
 * 23. Добавьте в {@link FailingConstructor предыдущее упражнение} класс с методом <b>dispose()</b>. Измените класс
 * {@link FailingConstructor} так, чтобы конструктор создавал один из таких объектов в поле класса; далее конструктор
 * может выдать исключение, после чего создает второй объект с необходимость вызова <b>dispose()</b>. Напишите код
 * для защиты от ошибок; в методе {@link #main(String[])} убедитесь в том, что защита распространяется на все
 * возможные ситуации с ошибками.
 * <p>
 * 24. Добавьте в класс {@link FailingConstructor} методе <b>dispose()</b>. Напишите код для правильного использования
 * этого класса.
 */
public class FailingConstructor {

    private WithDispose withDispose;
    private WithDispose withDispose2;

    public FailingConstructor(Object o) {
        withDispose = new WithDispose();

        if (o == null) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                withDispose.dispose();
                throw e;
            }
        }

        withDispose2 = new WithDispose();
    }

    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor(null);
            try {
                System.out.println(fc);
            } finally {
                System.out.println("cleanup..");
                fc.dispose();
            }
        } catch (Exception e) {
            System.out.println("Null reference in constructing object");
        }
    }

    private void dispose() {
        withDispose2.dispose();
        withDispose.dispose();
    }
}

class WithDispose {

    void dispose() {
        System.out.println("WithDispose.dispose()");
    }
}