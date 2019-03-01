package ru.myachin.access.local;

/**
 * 5. Создайте класс с полями и методами, обладающими разными уровнями доступа:
 * <b>public, private, protected, package-private</b>. Создайте объект этого класса и посмотрите, какие сообщения
 * выдает компилятор при попытке обращения к разным членам класса. Учтите, что классы, находящиеся в одном каталоге,
 * входят в "пакет по умолчанию".
 */
public class AccessControl {

    public int i4;
    protected int i3;
    /*package-private*/ int i2;
    private int i1;

    public static void main(String[] args) {
        AccessControl accessControl = new AccessControl();
        accessControl.i1 = 1;
        accessControl.i2 = 2;
        accessControl.i3 = 3;
        accessControl.i4 = 4;

        accessControl.privateMethod();
        accessControl.packagePrivateMethod();
        accessControl.protectedMethod();
        accessControl.publicMethod();
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    /*package-private*/ void packagePrivateMethod() {
        System.out.println("packagePrivateMethod");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    public void publicMethod() {
        System.out.println("publicMethod");
    }
}
