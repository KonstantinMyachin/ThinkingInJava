package ru.myachin.exceptions;

/**
 * 4. Созадйте ваш собственный класс исключения, используя ключевое словов <b>extends</b>. Напишите конструктор,
 * получающий строковый аргумент, и сохраните этот аргумент внутри объекта по ссылке на {@link String}. Напишите метод,
 * который выводит эту строку. Присоедините новый блок <b>try-catch</b> для проверки нового исключения.
 * <p>
 * 28. Измените упражнение 4 так, чтобы класс исключения был производным от {@link RuntimeException}. Покажите, что
 * компилятор позволяет опустить блок <b>try</b>
 *
 * @see Exception
 * @see RuntimeException
 */
public class OwnException extends RuntimeException {

    String msg;

    public OwnException(String message) {
        super(message);
        msg = message;
    }

    public static void main(String[] args) {
/*
        try {
            throw new OwnException("My own exception");
        } catch (OwnException e) {
            e.printMessage();
        }
*/
        throw new OwnException("My own RuntimeException");
    }

    void printMessage() {
        System.out.println(msg);
    }
}