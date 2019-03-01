package ru.myachin.exceptions;

/**
 * 18. Добавьте в <b>LostMessage.java</b> второй уровень потери исключений, чтобы исключание {@link HoHumException}
 * само замещалось третьим исключением.
 * <p>
 * 19. Исправьте недостаток <b>LostMessage.java</b>, защитив вызов в блоке <tt>finally</tt>
 */
public class LostMessage {
    public static void main(String[] args) {
        LostMessage lm = new LostMessage();
        try {
            try {
                lm.f();
            } finally {
                try {
                    lm.dispose();
                } catch (HoHumException e) {
                    System.out.println(e);
                } finally {
                    try {
                        throw new OneMoreException();
                    } catch (OneMoreException e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }
}

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "Очень важное исключение!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "Второстепенное исключение";
    }
}

class OneMoreException extends Exception {
    @Override
    public String toString() {
        return "Еще одно второстепенное исключание";
    }
}