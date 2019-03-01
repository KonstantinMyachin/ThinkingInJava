package ru.myachin.innerclasses;

import ru.myachin.innerclasses.fristpack.Interface;

/**
 * 9. Создайте интерфейс, содержащий минимум один метод. Реализуйте его, определяя внутренний класс в методе, который
 * возвращает ссылку на ваш интерфейс.
 * <p>
 * 10. Повтороите предыдущее упражнение, но определите внутренний класс в области действия внутри метода.
 * <p>
 * 13. Повторите упражнение 9 с анонимным внутренним классом.
 */
public class InnerClassInMethod {

    public static void main(String[] args) {
        InnerClassInMethod classAccess = new InnerClassInMethod();
        classAccess.getInterface().doSomething();
        classAccess.getAnonymousInterfaceImpl().doSomething();
    }

    Interface getInterface() {
        {
            class InterfaceImpl implements Interface {

                @Override
                public void doSomething() {
                    System.out.println("InterfaceImpl doSomething()");
                }
            }

            return new InterfaceImpl();
        }
    }

    Interface getAnonymousInterfaceImpl() {
        return new Interface() {
            @Override
            public void doSomething() {
                System.out.println("AnonymousInterfaceImpl doSomething()");
            }
        };
    }
}