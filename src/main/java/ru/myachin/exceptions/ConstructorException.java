package ru.myachin.exceptions;

/**
 * 21. Продемонстрируйте, что конструктор производного класса не может перехватывать исключения, возбужденные
 * конструктором базового класса.
 */
public class ConstructorException extends Exception {

    public ConstructorException() throws InstantiationException {

    }
}

class SubClassConstructorException {

    /* Compile error
        public SubClassConstructorException() {
            try {
                super();
            } catch (InvocationException e) {
                e.printStackTrace();
            }
        }
    */
    public SubClassConstructorException() {

    }
}