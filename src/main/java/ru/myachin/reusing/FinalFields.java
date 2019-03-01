package ru.myachin.reusing;

/**
 * 18. Создайте класс, содержащий два поля: <b>static final и final</b>. Продемонстрируйте различия между ними.
 */
public class FinalFields {

    private static final int ZERO = 0;
    private static int counter = ZERO;
    private final int id = ++counter;

    public static void main(String[] args) {
        FinalFields f1 = new FinalFields();
        System.out.println(f1.id);
        FinalFields f2 = new FinalFields();
        System.out.println(f2.id);
    }

    public int getId() {
        return id;
    }
}