package ru.myachin.generics;

import net.mindview.generics.CountedObject;
import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * 14. Измените пример <tt>BasicGeneratorDemo.java</tt>, чтобы в нем использовалась явная форма создания
 * {@link Generator} (то есть используйте явный вызов конструктора вместо обобщегго метода
 * {@link BasicGenerator#create(Class)}.
 */
public class BasicGeneratorDemo {

    public static void main(String[] args) {
        final BasicGenerator<CountedObject> generator = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }
}
