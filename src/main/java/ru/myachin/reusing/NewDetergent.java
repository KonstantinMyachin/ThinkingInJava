package ru.myachin.reusing;

/**
 * 2. Объявите новый класс, производный от <b>Detergent</b>. Переопределите метод <b>scrub()</b> и добавьте новый
 * метод с именем <b>sterilize()</b>.
 */
public class NewDetergent extends Detergent {

    public static void main(String[] args) {
        NewDetergent x = new NewDetergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.sterilize();
        System.out.println(x);
        System.out.println("Проверяем базовый класс");
        Detergent.main(args);
    }

    @Override
    public void scrub() {
        append(" NewDetergent.scrub()");
        super.scrub();
    }

    public void sterilize() {
        append(" sterilize()");
    }
}

class Cleanser {

    private String s = "Cleanser";

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }
}

class Detergent extends Cleanser {

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Проверяем базовый класс");
        Cleanser.main(args);
    }

    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }
}
