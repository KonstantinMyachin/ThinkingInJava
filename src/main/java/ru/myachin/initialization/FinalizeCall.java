package ru.myachin.initialization;

/**
 * 10. Создайте класс с методом {@link #finalize()}, который выводит сообщение. В методе {@link #main(String[])}
 * создайте объект вашего класса. Объясните поведение программы.
 */
public class FinalizeCall {

    public static void main(String[] args) {
        new FinalizeCall();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("Finalize was called!");
    }
}
