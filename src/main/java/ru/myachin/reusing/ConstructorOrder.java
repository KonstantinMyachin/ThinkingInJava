package ru.myachin.reusing;

/**
 * 4. Докажите, что конструкторы базового класса:
 * <ul>
 * <li>всегда вызываются</li>
 * <li>всегда вызываются перед исполнением конструкторов производного класса</li>
 * </ul>
 */
public class ConstructorOrder {

    public static void main(String[] args) {
        new SubClass();
    }
}

class SuperClass {

    static int order;

    SuperClass() {
        System.out.println("SuperClass order " + ++order);
    }
}

class SubClass extends SuperClass {

    SubClass() {
        System.out.println("SubClass order " + ++order);
    }
}
