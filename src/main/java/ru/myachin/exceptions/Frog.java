package ru.myachin.exceptions;

/**
 * 17. Измените пример <b>polymorphism/Frog.java</b>, чтобы он использовал <tt>try-finally</tt> для обеспечения
 * необходимых завершающих действий. Покажите, что программа работает даже при возврате из середины
 * <tt>try-finally</tt>
 *
 * @see Amphibian
 */
public class Frog extends Amphibian {
    private Characteristic p = new Characteristic("квакает");
    private Description t = new Description("есть жуков");

    public Frog() {
        System.out.println("Frog()");
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        try {
            System.out.println("Пока");
            return;
        } finally {
            frog.dispose();
        }
    }

    @Override
    protected void dispose() {
        System.out.println("завершение Frog");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Characteristic {
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Создаем Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("Завершаем Characteristic " + s);
    }
}

class Description {
    private String s;

    public Description(String s) {
        this.s = s;
        System.out.println("Создаем Description " + s);
    }

    protected void dispose() {
        System.out.println("Завршаем Description " + s);
    }
}

class LivingCreature {
    private Characteristic p = new Characteristic("Живое существо");
    private Description t = new Description("обычное живое существо");

    public LivingCreature() {
        System.out.println("LivingCreature");
    }

    protected void dispose() {
        System.out.println("dispose() в LivingCreature");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic p = new Characteristic("имеет сердце");
    private Description t = new Description("животное, не растение");

    public Animal() {
        System.out.println("Animal()");
    }

    @Override
    protected void dispose() {
        System.out.println("dispose() в Animal");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal {
    private Characteristic p = new Characteristic("может жить в воде");
    private Description t = new Description("и в воде, и на земле");

    public Amphibian() {
        System.out.println("Amphibian()");
    }

    @Override
    protected void dispose() {
        System.out.println("dispose() в Amphibian");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}