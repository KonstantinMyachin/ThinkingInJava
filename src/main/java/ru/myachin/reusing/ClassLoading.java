package ru.myachin.reusing;

/**
 * 23. Продемонстрируйте, что загрузка класса выполняется только один раз. Докажите, что загрузка может быть вызвана
 * как созданием первого экземпляра класса, так и обращением к статическогому члену.
 */
public class ClassLoading {

    public static void main(String[] args) {
        String s = StaticTest.s;
        new StaticTest();
    }

}

class StaticTest {
    static String s = "Loading class";

    static {
        System.out.println(s);
    }
}