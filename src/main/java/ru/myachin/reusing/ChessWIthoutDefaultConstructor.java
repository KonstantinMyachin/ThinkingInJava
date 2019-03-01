package ru.myachin.reusing;

/**
 * 6. Используя пример <b>Chess.java</b>, докажите утверждение: если не вызывать конструктор базового класса в
 * BoardGame, то компилятор "пожалуется" на то, что не может обнаружить в форме <b>Game()</b>. Вдобавок, вызов
 * конструктор базового класса должен быть первой командой в конструкторе производного класса. (Если вы вдруг забудете
 * об этом, компилятор вам тут же напомнит.)
 */
public class ChessWIthoutDefaultConstructor {
}

class Game {

    Game(int i) {
        System.out.println("Конструктор Game");
    }
}

class BoardGame extends Game {


    BoardGame(int i) {
        super(i);
        System.out.println("Конструктор BoardGame");
    }
}

class Chess extends BoardGame {

    Chess() {
        super(11);
        System.out.println("Конструктор Chess");
    }

    public static void main(String[] args) {
        new Chess();
    }
}
