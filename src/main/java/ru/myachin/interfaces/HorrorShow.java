package ru.myachin.interfaces;

interface Monster {
    void menace();
}

interface Lethal {
    void kill();
}

public class HorrorShow {

    public static void u(Monster b) {
        b.menace();
    }

    public static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    public static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);

        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

class VeryBadVampire implements Vampire {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}