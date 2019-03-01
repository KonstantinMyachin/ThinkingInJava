package ru.myachin.access;

/**
 * 6. Создайте класс с защищенными данными. Создайте в том же файле второй класс с методом, работающим с защищенными
 * данными из первого класса.
 */
class WithProtected {

    protected int i;
}

class ProtectedManipulation {

    public static void main(String[] args) {
        System.out.println(new WithProtected().i);
    }
}