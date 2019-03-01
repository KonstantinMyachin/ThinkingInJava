package ru.myachin.access.local;

import ru.myachin.access.Widget;

/**
 * 1. Определите класс в пакете. Создайте экземпляр класса за пределами пакета.
 * 4. Покажите, что методы со спецификатором <b>protected</b> обладают доступом в пределах пакета, но не являются
 * открытыми.
 *
 * @see ru.myachin.access.ForeignClass
 * @see SamePackagedClass
 * @see ru.myachin.access.Widget
 */
public class PackagedClass {

    protected String s;

    public static void main(String[] args) {
        new Widget();
    }
}