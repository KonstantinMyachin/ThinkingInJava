package ru.myachin.reusing;

/**
 * 21. Создайте класс с неизменным <b>(final)</b> методом. Создайте производный класс и попытайтесь переопределить этот
 * метод.
 */
public class FinalMethod {

    final void finalMethod() {
        System.out.println("finalMethod()");
    }
}

class FinalMethodChild extends FinalMethod {

//    void finalMethod() {}
}
