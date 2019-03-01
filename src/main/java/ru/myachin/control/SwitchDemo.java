package ru.myachin.control;

/**
 * 8. Создайте команду <b>switch</b>, которая выводит сообщение в каждой секции <b>case</b>. Разместите ее в цикл
 * <b>for</b>, проверяющем все допустимые значения <b>case</b>. Каждая секция <b>case</b> должна завершаться командой
 * <b>break</b>. Затем удалите команды <b>break</b> и посмотрите, что произойдет.
 */
public class SwitchDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    System.out.println("It's zero");
//                    break;
                case 1:
                    System.out.println("It's one");
//                    break;
                case 2:
                    System.out.println("It's two");
//                    break;
                case 3:
                    System.out.println("It's three");
//                    break;
                case 4:
                    System.out.println("It's four");
//                    break;
                default:
                    System.out.println("It's unknown integer");
            }
        }
    }
}
