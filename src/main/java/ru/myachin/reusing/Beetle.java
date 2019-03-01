package ru.myachin.reusing;

/**
 * 24. В файле <b>Beetle.java</b> создайте еще один тип, производный от <b>Beetle</b>, в таком же формате, как и у
 * других классов. Проследите за работой программы и объясните результат.
 */
public class Beetle extends Inspect {

    private static int x2 = printInt("Поле static Beetle.x2 инициализировано");
    private int k = printInt("Поле Beetle.k инициализировано");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    public static void main(String[] args) {
        System.out.println("Конструктор Beetle");
        Beetle b = new BeetleChild();
    }
}

class Inspect {

    private static int x1 = printInt("Поле static Inspect.x1 инициализировано");
    protected int j;
    private int i = 9;

    Inspect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInt(String s) {
        System.out.println(s);
        return 47;
    }
}

class BeetleChild extends Beetle {

    static {
        System.out.println("BeetleChild initialization");
    }
}