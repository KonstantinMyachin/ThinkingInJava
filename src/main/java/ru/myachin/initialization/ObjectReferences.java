package ru.myachin.initialization;

/**
 * 17. Создайте класс с конструктором, получающим аргумент {@link String}. Выведите значением аргумента во время
 * конструирования. Создайте массив ссылок на этот класс, но не создавайте объекты, которыми заполняется массив.
 * Запустте программу и посмотрите, будут ли выводиться сообщения при вызове конструкторов.
 */
public class ObjectReferences {

    public ObjectReferences(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        ObjectReferences[] references = new ObjectReferences[5];
    }
}