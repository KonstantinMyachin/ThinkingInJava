package ru.myachin.innerclasses;

/**
 * 1. Напишите класс с именем <b>Outer</b>, содержащий внутренний класс с именем <b>Inner</b>. Добавьте в <b>Outer</b>
 * метод, возвращающий объект типа <b>Inner</b>. В метод <b>main()</b> создайте и инициализируйте ссылку на
 * <b>Inner</b>.
 * <p>
 * 3. Измените упражнение 1 так, чтобы класс {@link Outer} содержал закрытое поле {@link String} (инициализируемое в
 * конструкторе), а класс {@link Inner} содрежал метод {@link #toString()} для вывода этого поля. Создайте объект типа
 * {@link Inner} и выведите его.
 */
public class Outer {

    private String s;

    public Outer(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Inner inner = new Outer("Java").getInner();
        System.out.println(inner);
    }

    Inner getInner() {
        return new Inner();
    }

    class Inner {

        public Inner() {
            System.out.println("Outer.Inner Constructor");
        }

        @Override
        public String toString() {
            return s;
        }
    }
}