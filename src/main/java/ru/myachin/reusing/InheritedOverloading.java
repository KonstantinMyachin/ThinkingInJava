package ru.myachin.reusing;

/**
 * 13. Создайте класс с троекратно перегруженным методом. Объявите новый класс производный от него, добавьте новую
 * перегрузку метода и покажите, что все четыре метода доступны в производном классе.
 */
public class InheritedOverloading {

    public static void main(String[] args) {
        ChildOverload childOverload = new ChildOverload();
        childOverload.doSomething(Integer.MAX_VALUE);
        childOverload.doSomething('c');
        childOverload.doSomething(true);
        childOverload.doSomething("");
    }
}

class ParentOverload {

    void doSomething(int i) {
        System.out.println("doSomething(int i)");
    }

    void doSomething(char c) {
        System.out.println("doSomething(char c)");
    }

    void doSomething(boolean b) {
        System.out.println("doSomething(boolean b)");
    }
}

class ChildOverload extends ParentOverload {

    void doSomething(String s) {
        System.out.println("doSomething(String s)");
    }
}