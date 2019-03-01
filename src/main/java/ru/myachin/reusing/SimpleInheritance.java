package ru.myachin.reusing;

/**
 * 5. Создайте два класса A и B, имеющие конструкторы по умолчанию (с пустым списком аргументов), которые выводят
 * сообщение о вызове. Создайте новыый класс C, производный от A; создайте в C поле типа B. Не создавайте конструктор
 * C. Создайте объект класса C и проследите за происходящем.
 *
 * @see SimpleInheritance2
 */
public class SimpleInheritance {

    public static void main(String[] args) {
//        @see SimpleInheritance2
//        new C();
        new C(Integer.MAX_VALUE);
    }
}

class A {

//    @see SimpleInheritance2
/*
    A() {
        System.out.println("Constructor A");
    }
*/

    A(int i) {
        System.out.println("Constructor A with int argument");
    }
}

class B {

    //    @see SimpleInheritance2
/*
    B() {
        System.out.println("Constructor B");
    }
*/

    B(int i) {
        System.out.println("Constructor B with int argument");
    }
}

class C extends A {

//    @see SimpleInheritance2
//    B b = new B();

    B b;

    C(int i) {
        super(i);
        b = new B(i);
        System.out.println("Constructor C with int argument");
    }
}