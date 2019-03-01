package ru.myachin.interfaces;

/**
 * 4. Создайте абстрактный <b>(abstract)</b> класс без методов. Произведите от него класс и добавьте метод. Создайте
 * статический <b>(static)</b> метод, получающий ссылку на базовый класс, проведите нисходящее преобразование к
 * производному типу и вызовите его метод. Продемонстрируйте, что такой способ работает, в методе <b>main()</b>.
 * Теперь поместите в определение метода из базового класса ключевое слово <b>abstract</b>, и необходимость в
 * нисходящем преобразовании исчезнет.
 */
public class AbstractBase {

    public static void main(String[] args) {
        SimpleClass.staticMethod(new SimpleClass());
    }

}

abstract class AbstractClass {

    abstract void doSomething();
}

class SimpleClass extends AbstractClass {

    static void staticMethod(AbstractClass base) {
//        ((SimpleClass) base).doSomething();
        base.doSomething();
    }

    void doSomething() {
        System.out.println("doSomething()");
    }
}