package ru.myachin.polymorphism.shape;

/**
 * 2. Добавьте аннотация {@link Override} в пример с фигурами.
 * <p>
 * 3. Включите в базовый класс <b>Shape</b> новый метод, выводящий сообщение, но не переопределяйте его в производных
 * классах. Объясните результат. Переопределите его в одном из производных классов и посмотрите, что происходит.
 * Наконец, переопределите метод во всех производных классах.
 */
public class Shape {

    protected boolean highLighted;

    public void draw() {
    }

    public void erase() {
    }

    public void newMethod() {
        System.out.println("Shape.newMethod()");
    }

    public void highLight() {
        highLighted = true;
    }

    public void clearHighLight() {
        highLighted = false;
    }
}