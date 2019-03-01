package ru.myachin.polymorphism;

/**
 * 17. По образцу <b>Transmogrify.java</b> создайте класс <b>Starship</b> со сылкой на объект <b>AlterStatus</b>,
 * который может обозначать одно из трех состояний. Включите методы изменения состояний.
 */
public class Starship {

    private AlterStatus alterStatus = new GreenAlterStatus();

    public static void main(String[] args) {
        Starship starship = new Starship();
        System.out.println(starship);
        starship.changeAlterStatus(new YellowAlterStatus());
        System.out.println(starship);
        starship.changeAlterStatus(new RedAlterStatus());
        System.out.println(starship);
    }

    public void changeAlterStatus(AlterStatus newAlterStatus) {
        alterStatus = newAlterStatus;
    }

    @Override
    public String toString() {
        return alterStatus.getStatus();
    }
}

class AlterStatus {

    String getStatus() {
        return "None";
    }
}

class GreenAlterStatus extends AlterStatus {

    @Override
    String getStatus() {
        return "Green";
    }
}

class YellowAlterStatus extends AlterStatus {

    @Override
    String getStatus() {
        return "Yellow";
    }
}

class RedAlterStatus extends AlterStatus {

    @Override
    String getStatus() {
        return "Red";
    }
}