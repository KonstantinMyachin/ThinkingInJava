package ru.myachin.initialization;

/**
 * 12. Включите в класс с именем <b>Tank</b> (емкость), который можно наполнить и опустошить.
 * <b><i>Условие "готовности"</i></b> требует, чтобы он был пуст перед очисткой. Напишите метод {@link #finalize()},
 * проверяющий это условие. В методе {@link #main(String[])} протестируйте все возможные случаи использование вашего
 * класса.
 */
public class Tank {

    private static int counter;
    int id = counter++;
    boolean full;

    private Tank() {
        System.out.println(String.format("Tank %d created", id));
        full = true;
    }

    public static void main(String[] args) {
        new Tank().empty();
        new Tank();
        System.gc();
        System.runFinalization();
    }

    private void empty() {
        full = false;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        if (full) {
            System.out.println(String.format("Error: tank %d must be empty at cleanup", id));
        } else {
            System.out.println(String.format("Tank %d cleaned up OK", id));
        }
    }
}
