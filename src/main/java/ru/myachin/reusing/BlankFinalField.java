package ru.myachin.reusing;

/**
 * 19. Создайте класс с пустой <b>final-ссылкой</b> на объект. Проведите инициализацию пустой константы во всех
 * конструкторах. Продемонстрируйте гарантированную инициализацию <b>final</b> перед использованием и невозможность
 * ее изменения после инициализации.
 */
public class BlankFinalField {

    private final String s;

    BlankFinalField() {
        s = "Default value";
    }

    BlankFinalField(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        BlankFinalField blankFinalField = new BlankFinalField();
        System.out.println(blankFinalField.s);
//        blankFinalField.s = "New value"
    }
}