package ru.myachin.innerclasses;

import ru.myachin.innerclasses.fristpack.Interface;

/**
 * 11. Создайте закрытый внутренний класс, реализующий открытый интерфейс. Напишите метод, который возвращает ссылку
 * на экземпляр закрытого внутреннего класса, преобразованную к интерфейсу восходящим преобразованием. Чтобы показать,
 * что внутренний класс полностью закрыт, попробуйте выполнить нисходящее преобразование к нему.
 */
public class PrivateInnerClassAccess {

    public static void main(String[] args) {
        Interface anInterface = new OuterClass().getInnerClassInterface();
        anInterface.doSomething();
//        ((PrivateInnerClass) anInterface).doSomething(); cannot find a private class
    }
}

class OuterClass {

    Interface getInnerClassInterface() {
        return new PrivateInnerClass();
    }

    private class PrivateInnerClass implements Interface {

        @Override
        public void doSomething() {
            System.out.println("PrivateInnerClass doSomething()");
        }
    }
}