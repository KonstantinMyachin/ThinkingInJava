package ru.myachin.exceptions;

/**
 * 10. Создайте класс с двумя методами, <b>f()</b> и <b>g()</b>. В методе <b>g()</b> возбудите исключение того типа,
 * который вы определили ранее. В методе <b>f()</b> вызовите <b>g()</b>, перехватите исключение и в предложении
 * <tt>catch</tt> возбудите новое исклюение (второй тип, который вам необходимо определить). Проверье этот код в
 * {@link #main(String[])}
 */
public class ChangeException {

    static void f() throws SecondException {
        try {
            g();
        } catch (FirstException e) {
            throw new SecondException();
        }
    }

    static void g() throws FirstException {
        throw new FirstException();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (SecondException e) {
            System.out.println(e);
        }
    }
}

class FirstException extends Exception {

}

class SecondException extends Exception {

}