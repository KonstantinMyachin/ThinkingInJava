package ru.myachin.exceptions;

/**
 * 30. Измените пример Human.java так, чтобы исключения наследовали от {@link RuntimeException}. Измените метод
 * <b>main()</b> так, чтобы прием из примера <b>TurnOffChecking.java</b> использовался для обработки разных типов
 * исключений.
 */
public class Human {

    static void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new Annoyance();
                case 1:
                    throw new Sneeze();
                default:
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        throwRuntimeException(2);
        for (int i = 0; i < 2; i++) {
            try {
                throwRuntimeException(i);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (Sneeze e) {
                    System.out.println("Sneeze was caught");
                } catch (Annoyance e) {
                    System.out.println("Annoyance was caught");
                } catch (Throwable throwable) {
                    System.out.println(throwable);
                }
            }
        }
    }
}

class Annoyance extends RuntimeException {

}

class Sneeze extends Annoyance {

}