package ru.myachin.reusing;

/**
 * 8. Создайте базовый класс с единственным конструктором, не являющимся конструктором по умолчанию, и производный
 * класс с конструктром как по умолчанию (без аргументов), так и с аргументами. В конструкторе производного класса
 * вызовите конструктор базового класса.
 */
public class CallBaseConstructor {

    public static void main(String[] args) {
        new Child();
        new Child(Integer.MIN_VALUE);
    }
}

class Parent {

    Parent(int i) {
        System.out.println("Parent non default constructor, i = " + i);
    }
}

class Child extends Parent {


    Child() {
        super(Integer.MAX_VALUE);
    }

    Child(int i) {
        super(i);
        System.out.println("Child non default constructor, i = " + i);
    }
}