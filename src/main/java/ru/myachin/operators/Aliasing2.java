package ru.myachin.operators;

/**
 * 3. Создайте {@link Aliasing класс с полем типа float}. Используйте его для демонстрации совмещения имен.
 */
public class Aliasing2 {

    static void setF(Aliasing y) {
        y.f = 1;
    }

    public static void main(String[] args) {
        Aliasing x = new Aliasing();
        x.f = 2;
        System.out.println(x.f);

        setF(x);
        System.out.println(x.f);
    }
}