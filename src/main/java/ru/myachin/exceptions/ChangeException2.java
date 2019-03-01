package ru.myachin.exceptions;

/**
 * 11. Повторите {@link ChangeException предыдущее упражнение}, но на этот раз в предложении <b>catch</b> преобразуйте
 * исключение метода {@link ChangeException#g()} в {@link RuntimeException}
 */
public class ChangeException2 {

    static void f() {
        try {
            g();
        } catch (FirstException e) {
            throw new RuntimeException(e);
        }
    }

    static void g() throws FirstException {
        throw new FirstException();
    }

    public static void main(String[] args) {
        f();
    }
}