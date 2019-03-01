package ru.myachin.operators;

/**
 * 5. Создайте класс <b>Dog</b>, содержащий два поля типа <b>String: name, says</b>. В методе <b>main()</b> создайте
 * два объекта <b>Dog</b> с разными именами <b>(spot и scruffy)</b> и сообщениями. Выведите значения обоих полей для
 * каждого из объектов.
 */
public class Dog {

    String name;
    String says;

    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    public static void main(String[] args) {
        Dog spot = new Dog("spot", "My name is spot");
        Dog scruffy = new Dog("scruffy", "My name is scruffy");

        System.out.println(spot.name + ": " + spot.says);
        System.out.println(scruffy.name + ": " + scruffy.says);
    }
}