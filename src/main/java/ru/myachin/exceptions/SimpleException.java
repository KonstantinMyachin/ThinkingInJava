package ru.myachin.exceptions;

/**
 * 1. Создайте класс с методом <b>main()</b>, возбуждающим исключение типа {@link Exception} из блока <b>try</b>.
 * Задайте в конструкторе для {@link Exception#Exception(String)} строковый аргумента. Перехватите исключение в блоке
 * <b>catch</b> и распечатайте текст аргумента. Добавьте блок <b>finally</b> и выведите сообщение как доказательство
 * его выполнения.
 */
public class SimpleException {

    public static void main(String[] args) {
        try {
            throw new Exception("Exception description");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("We are in finally block");
        }
    }
}