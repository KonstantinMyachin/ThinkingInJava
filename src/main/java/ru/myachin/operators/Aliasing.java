package ru.myachin.operators;

/**
 * 2. Создайте класс с поле типа float. Используйте его для демонстрации совмщения имен.
 */
public class Aliasing {

    float f;

    public static void main(String[] args) {
        Aliasing aliasing1 = new Aliasing();
        Aliasing aliasing2 = new Aliasing();
        aliasing1.f = 9f;
        aliasing2.f = 47f;
        System.out.println("Aliasing1.f = " + aliasing1.f);
        System.out.println("Aliasing1.2 = " + aliasing2.f);
        aliasing1 = aliasing2;
        System.out.println("Aliasing1.f = " + aliasing1.f);
        System.out.println("Aliasing1.2 = " + aliasing2.f);
        aliasing1.f = 27f;
        System.out.println("Aliasing1.f = " + aliasing1.f);
        System.out.println("Aliasing1.2 = " + aliasing2.f);
    }
}
