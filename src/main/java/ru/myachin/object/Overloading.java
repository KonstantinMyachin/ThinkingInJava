package ru.myachin.object;

/**
 * 16. Найдите в главе 5 <b>Overloading.java</b> и добавьте в него комментарии <b>javadoc</b>. Преобразуйте их в
 * страницу HTML и просмотрите в браузере.
 */
public class Overloading {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("Перегруженный метод");
        }

        new Tree();
    }
}

/**
 * Класс описывающий сущность "Дерево".
 */
class Tree {

    /**
     * Высота дерева.
     */
    int height;

    /**
     * Конструктор без параметров. Отвечает за саженец.
     */
    public Tree() {
        System.out.println("Сажаем росток");
        height = 0;
    }

    /**
     * Перегруженный конструктор. Позволяет создать дерево с заданной высотой.
     *
     * @param initialHeight высота дерева.
     */
    public Tree(int initialHeight) {
        this.height = initialHeight;
        System.out.println("Создание нового дерева высотой " + height + " м.");
    }

    /**
     * Метод выводит в консоль выосту дерева.
     */
    void info() {
        System.out.println("Дерево высотой " + height + " м.");
    }

    /**
     * Перегруженный метод, позволяющий выводит дополнительную информацию перед тем, как вывести в консоль высоту
     * дерева.
     *
     * @param s дополнительная информация
     */
    void info(String s) {
        System.out.println(s + ": Дерево высотой " + height + "м.");
    }
}
