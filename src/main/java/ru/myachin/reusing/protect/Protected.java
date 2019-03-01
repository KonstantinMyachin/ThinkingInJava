package ru.myachin.reusing.protect;

/**
 * 15. Создайте класс в пакете. Ваш класс должен содержать метод со спецификатором <b>protected</b>. Попытайтесь
 * вызвать метод <b>protected</b> за пределами пакета, и объясните, что происходит. Затем создайте класс, производный
 * от вашего, и вызовите метод <b>protected</b> из другого метода вашего производного класса.
 */
public class Protected {

    protected void protectedMethod() {
        System.out.println("protectedMethod()");
    }
}