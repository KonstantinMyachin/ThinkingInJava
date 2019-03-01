package ru.myachin.innerclasses;

/**
 * 26. Создайте класс с внетренним классом, имеющим конструктор с аргументами (не являющийся конструктором по
 * умолчанию). Создайте второй класс с внетренним классом, наследующим от первого внутреннего класса.
 */
public class InnerClassInheritance {

    public static void main(String[] args) {
        new SecondClass().new InnerClass(new InnerClassInheritance(), 5);
    }

    class InnerClassWithNonDefaultConstructor {
        public InnerClassWithNonDefaultConstructor(int i) {
            System.out.println("Constructor argument = " + i);
        }
    }
}

class SecondClass {

    class InnerClass extends InnerClassInheritance.InnerClassWithNonDefaultConstructor {
        public InnerClass(InnerClassInheritance inner, int i) {
            inner.super(i);
        }
    }
}
