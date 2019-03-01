package ru.myachin.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. Создайте новый класс с именем <b>Gerbil</b> с полем <b>gerbilNumber</b> типа <b>int</b>, инициализируемым в
 * конструкторе. Определите в нем метод hop(), который выводит значение <b>gerbilNumber</b> и короткое сообщение.
 * Создайте контейнер {@link ArrayList} и добавьте в него объект <b>Gerbil</b>. Используйте метод {@link List#get(int)}
 * для перебора элементов и вызова <b>hop()</b> для каждого объекта <b>Gerbil</b>.
 * 8. Измените {@link Gerbil упражнение 1} так, чтобы для перемещения по контейнеру {@link List} при вызовах
 * {@link #hop()} использовался {@link Iterator}
 */
public class Gerbil {

    private int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public static void main(String[] args) {
        List<Gerbil> gerbilList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            gerbilList.add(new Gerbil(i));
        }

        for (Gerbil gerbil : gerbilList) {
            gerbil.hop();
        }

        System.out.println("Through iterator");
        Iterator<Gerbil> it = gerbilList.iterator();
        while (it.hasNext()) {
            Gerbil gerbil = it.next();
            gerbil.hop();
        }
    }

    @Override
    public String toString() {
        return "gerbil with number " + gerbilNumber;
    }

    public void hop() {
        System.out.println("Hopping " + this);
    }
}