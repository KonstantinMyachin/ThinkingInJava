package ru.myachin.innerclasses;

interface U {

    void firstMethod();

    void secondMethod();

    void thirdMethod();
}

/**
 * Создайте интерфейс <b>U</b> с тремя методами. Создайте класс <b>A</b> с методом, который создает ссылку на <b>U</b>
 * посредством построения анонимного внутреннего класса. Создайте второй класс <b>B</b>, который содержит массив
 * <b>U</b>. Класс <b>B</b> содержит один метод, который получает и сохраняет ссылку <b>U</b> в массиве; второй метод,
 * который сбрасывает ссылку в массиве (определяемую аргументом метода) в состояние <tt>null</tt>; и третий метод,
 * который перебирает элементы массива и вызывает методы <b>U</b>. В методе <b>main()</b> создайте группу объектов
 * <b>A</b> и один объект <b>B</b>. Заполните объект <b>B</b> ссылками <b>U</b>, произведенный объектами <b>A</b>.
 * Используйте <b>B</b> для выполнения обратных вызовов по всем объектам <b>A</b>. Удалите некоторые ссылки на <b>U</b>
 * из <b>B</b>.
 */
public class UAB {

    public static void main(String[] args) {
        A[] aArray = {
                new A(), new A(), new A(), new A()
        };

        B b = new B(aArray.length);
        for (A a : aArray) {
            b.add(a.getUInstance());
        }

        for (int i = 0, n = aArray.length; i < n; i++) {
            if (i % 2 == 0) {
                b.resetItem(i);
            }
        }

        b.callInterfaceMethods();
    }
}

class A {

    U getUInstance() {
        return new U() {
            @Override
            public void firstMethod() {
                System.out.println("Anonymous U Instance firstMethod");
            }

            @Override
            public void secondMethod() {
                System.out.println("Anonymous U Instance secondMethod");
            }

            @Override
            public void thirdMethod() {
                System.out.println("Anonymous U Instance thirdMethod");
            }
        };
    }
}

class B {

    private U[] uItems;
    private int counter;

    public B(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Размер массива должен быть положительным числом.");
        }
        uItems = new U[count];
    }

    public void add(U item) {
        int i = counter;
        if (counter++ >= uItems.length) {
            throw new RuntimeException("Массив объектов переполнен");
        }

        uItems[i] = item;
    }

    public void resetItem(int i) {
        if (i >= uItems.length || i < 0) {
            throw new IllegalArgumentException("В массиве элементов нет элемента с соответствующим индексом " + i);
        }

        if (uItems[i] == null) {
            throw new IllegalArgumentException("Элемент с порядковым номером " + i + " уже сброшен");
        }

        uItems[i] = null;
    }

    public void callInterfaceMethods() {
        for (U uItem : uItems) {
            if (uItem != null) {
                uItem.firstMethod();
                uItem.secondMethod();
                uItem.thirdMethod();
            }
        }
    }
}