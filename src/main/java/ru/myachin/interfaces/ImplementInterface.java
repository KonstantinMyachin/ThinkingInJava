package ru.myachin.interfaces;

import ru.myachin.interfaces.ownpackage.AnInterface;

/**
 * 5. Создайте интерфейс, содержащий три метода, в отдельном пакете. Реализуйте этот интерфейс в другом пакете.
 * <p>
 * 6. Докажите, что все методы интерфейса автоматически являются открытими.
 *
 * @see AnInterface
 */
public class ImplementInterface {

    public static void main(String[] args) {
        AnInterface anInterface = new InterfaceImpl();
        anInterface.firstMethod();
        anInterface.secondMethod();
        anInterface.thirdMethod();
    }
}

class InterfaceImpl implements AnInterface {

    @Override
    public void firstMethod() {
        System.out.println("firstMethod()");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    @Override
    public void thirdMethod() {
        System.out.println("thirdMethod()");
    }
}