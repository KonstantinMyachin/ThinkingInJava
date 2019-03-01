package ru.myachin.reusing;

/**
 * 3. Докажите следующее: Даже если коструктор сабкласса не определен, компилятор сгенерирует конструктор по умолчанию,
 * в котором также вызывается конструктор суперкласса.
 */
public class CartoonWithDefaultConstructor extends Cartoon {

    public static void main(String[] args) {
        new CartoonWithDefaultConstructor();
    }
}

class Art {

    Art() {
        System.out.println("Конструктор Art");
    }
}

class Drawing extends Art {

    Drawing() {
        System.out.println("Конструктор Drawing");
    }
}

class Cartoon extends Drawing {

    Cartoon() {
        System.out.println("Конструктор Cartoon");
    }
}
