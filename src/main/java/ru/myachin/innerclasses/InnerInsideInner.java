package ru.myachin.innerclasses;

/**
 * 19. Создайте класс, содержащий внутренний класс, который, в свою очередь, содержит внутренний класс. Повтороите
 * упражнение с вложенными классами. Обратите внимание на имена файлов <b>.class</b>, создаваемых компилятором.
 */
public class InnerInsideInner {

    public static void main(String[] args) {
        new InnerInsideInner().new Inner().new InsideInner();
        new Nested();
        new Nested.InsideNested();
    }

    static class Nested {
        public Nested() {
            System.out.println("Nested class constructor");
        }

        static class InsideNested {
            public InsideNested() {
                System.out.println("InsideNested class constructor");
            }
        }
    }

    class Inner {
        public Inner() {
            System.out.println("Inner class constructor");
        }

        class InsideInner {
            public InsideInner() {
                System.out.println("InsideInner class constructor");
            }
        }
    }
}