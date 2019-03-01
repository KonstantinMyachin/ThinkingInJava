package ru.myachin.innerclasses;

/**
 * 2. Создайте класс, который содержит {@link String} и метод {@link #toString()} для вывода хранимой строки. Добавьте
 * несколько экземпляров нового класса в объект {@link Sequence} и выведите их.
 */
public class StringHolder {

    private String holder;

    public StringHolder(String holder) {
        this.holder = holder;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(5);
        sequence.add(new StringHolder("One"));
        sequence.add(new StringHolder("Two"));
        sequence.add(new StringHolder("Three"));
        sequence.add(new StringHolder("Four"));
        sequence.add(new StringHolder("Five"));

        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

    @Override
    public String toString() {
        return holder;
    }
}
