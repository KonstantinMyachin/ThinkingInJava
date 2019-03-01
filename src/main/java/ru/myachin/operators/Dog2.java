package ru.myachin.operators;

/**
 * 6. В {@link Dog упражнении 5} создайте новую ссылку на <b>Dog</b> и присвойте ее объекту <b>spot</b>. Сравните ссылки
 * оператором <b>==</b> и методом <b>equals()</b>.
 */
public class Dog2 {

    public static void main(String[] args) {
        Dog spot = new Dog("spot", "My name is spot");
        Dog anotherDog = new Dog("anotherDog", "I don't know my name");
        anotherDog = spot;

        System.out.println(spot == anotherDog);
        System.out.println(spot.equals(anotherDog));
    }
}