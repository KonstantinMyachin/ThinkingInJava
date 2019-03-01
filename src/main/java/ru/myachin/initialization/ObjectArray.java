package ru.myachin.initialization;

/**
 * 18. Завершите {@link ObjectReferences предыдущее упражнение} - создайте объекты, которыми заполняется массив ссылок.
 */
public class ObjectArray {

    public static void main(String[] args) {
        ObjectReferences[] references = {
                new ObjectReferences("One"),
                new ObjectReferences("Two"),
                new ObjectReferences("Three"),
                new ObjectReferences("Four"),
                new ObjectReferences("Five")
        };
    }
}