package ru.myachin.innerclasses;

import ru.myachin.interfaces.DangerousMonster;
import ru.myachin.interfaces.Vampire;

/**
 * 14. Измените пример {@link ru.myachin.interfaces.HorrorShow}, реализовав {@link ru.myachin.interfaces.DangerousMonster}
 * и {@link ru.myachin.interfaces.Vampire} как анонимные классы.
 */
public class HorrorShow {

    public static void main(String[] args) {
        DangerousMonster monster = new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("Anonymous Dangerous Monster destroy");
            }

            @Override
            public void menace() {
                System.out.println("Anonymous Dangerous Monster menace");
            }
        };

        ru.myachin.interfaces.HorrorShow.u(monster);
        ru.myachin.interfaces.HorrorShow.v(monster);

        Vampire vampire = new Vampire() {
            @Override
            public void drinkBlood() {
                System.out.println("Anonymous Vampire drinkBlood");
            }

            @Override
            public void destroy() {
                System.out.println("Anonymous Vampire destroy");
            }

            @Override
            public void kill() {
                System.out.println("Anonymous Vampire kill");
            }

            @Override
            public void menace() {
                System.out.println("Anonymous Vampire menace");
            }
        };

        ru.myachin.interfaces.HorrorShow.u(vampire);
        ru.myachin.interfaces.HorrorShow.v(vampire);
        ru.myachin.interfaces.HorrorShow.w(vampire);
    }
}