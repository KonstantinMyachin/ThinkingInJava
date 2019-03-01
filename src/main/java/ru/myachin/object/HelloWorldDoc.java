package ru.myachin.object;

/**
 * 15. Возьмите программу из {@link HelloWorld упражнения 2} и добавьте к ней документацию в комментариях. Извлеките
 * эту документацию в HTML-файл с помощью <b>javadoc</b> и просмотрите полученную страницу в браузере.
 */
public class HelloWorldDoc {

    /**
     * Программа перенаправляет вызов к статическому методу {@link HelloWorld#main(String[])}.
     *
     * @param args аргументы программы
     */
    public static void main(String[] args) {
        HelloWorld.main(args);
    }
}