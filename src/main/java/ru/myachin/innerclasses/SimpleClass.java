package ru.myachin.innerclasses;

/**
 * 7. Создайте класс, содержащий заыкрытое поле и закрытый метод. Создайте внутренний класс с методом, который изменяет
 * поле внешнего класса и вызывает метод внешнего класса. Во втором методе внешнего класса создайте объект внутреннего
 * класса и вызовите его метод; продемонстрируйте эффект на объекте внешнего класса.
 * <p>
 * 8. Проверьте, доступны ли для внешнего класса закрытые элементы внутреннего класса.
 * <p>
 * 12. Повторите упражнение 7 с анонимным внутренним классом.
 */
public class SimpleClass {

    private String s;

    public SimpleClass(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        SimpleClass simpleClass = new SimpleClass("C++");
        simpleClass.changeS("Java");
        simpleClass.changeSThroughAnonymousClass("Java++");
    }

    private void printS() {
        System.out.println(s);
    }

    public void changeS(String s) {
        InnerClass innerClass = new InnerClass();
        innerClass.setS(s + innerClass.i); //has access to private variable from inner class
    }

    public void changeSThroughAnonymousClass(String s) {
        new Object() {
            public void setS(String s) {
                SimpleClass.this.s = s;
                printS();
            }
        }.setS(s);
    }

    private class InnerClass {

        private int i = 5;

        public void setS(String s) {
            SimpleClass.this.s = s;
            printS();
        }
    }
}