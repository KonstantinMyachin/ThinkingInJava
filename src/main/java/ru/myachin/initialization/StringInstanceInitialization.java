package ru.myachin.initialization;

/**
 * 15. Создайте класс, производный от {@link String}, инициализируемый в секции инициализации экземпляров.
 */
public class StringInstanceInitialization {

    private String s;

    {
        s = "Initialize in non-static block";
        System.out.println(s);
    }

    private StringInstanceInitialization() {
        s = "Initialize in constructor";
        System.out.println(s);
    }

    public static void main(String[] args) {
        new StringInstanceInitialization();
    }

}