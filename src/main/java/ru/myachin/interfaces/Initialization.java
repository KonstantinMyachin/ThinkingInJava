package ru.myachin.interfaces;

/**
 * 3. Создайте базовый класс с определением метода <b>abstract print()</b>, переопредляемого производными классами.
 * Переопределенная версия метода выводит значение переменной <b>int</b>, определенный в производном классе. В точке
 * определения этой переменной присвойте ей ненулевое значение. Вызовите этот метод в конструкторе базового класса.
 * В методе <b>main()</b> создайте объект производного типа, а затем вызовите его метод <b>print()</b>. Объясните
 * результат работы программы.
 */
public class Initialization {

    public static void main(String[] args) {
        new SubClass().print();
    }
}

abstract class BaseClass {

    BaseClass() {
        print();
    }

    abstract void print();
}

class SubClass extends BaseClass {

    private int i = 5;

    @Override
    void print() {
        System.out.println(i);
    }
}