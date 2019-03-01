package ru.myachin.innerclasses;

import ru.myachin.innerclasses.fristpack.Interface;
import ru.myachin.innerclasses.secondpack.Outer;

/**
 * 6. Создайте интерфейс, содержащий хотя бы один метод, в отдельном пакете. Создайте класс в другом пакете. Добавьте
 * защищенный внутренний класс, реализующий интерфейс. В третьем пакете создайте производный класс; внутри метода
 * верните объект защищенного внутреннего класса, преобразованный в интерфейс.
 *
 * @see ru.myachin.innerclasses.fristpack.Interface
 * @see Outer
 */
public class ProtectedInnerClass extends Outer {

    public static void main(String[] args) {
        new ProtectedInnerClass().getProtected().doSomething();
    }

    Interface getProtected() {
        return new InnerClass();
    }
}
