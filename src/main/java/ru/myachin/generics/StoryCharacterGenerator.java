package ru.myachin.generics;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * 8. По образцу {@link net.mindview.generics.coffee.Coffee} создайте иерархию персонажей своего любимого фильма
 * <tt>StoryCharacters</tt>, разделив их на положительных <tt>(GoodGuys)</tt> и отрицательных <tt>(BadGuys)</tt>.
 * Создайте генерато для <tt>StoryCharacters</tt> по образцу {@link net.mindview.generics.coffee.CoffeeGenerator}
 */
public class StoryCharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {

    private static Random random = new Random(47);

    private int size = 0;

    private Class[] types = {
            SpiderMan.class, Thor.class, Hulk.class,
            Chameleon.class, Vulture.class, Electro.class
    };

    public StoryCharacterGenerator() {

    }

    public StoryCharacterGenerator(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        StoryCharacterGenerator generator = new StoryCharacterGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }

        for (StoryCharacter storyCharacter : new StoryCharacterGenerator(5)) {
            System.out.println(storyCharacter);
        }
    }

    @Override
    public StoryCharacter next() {
        try {
            return ((StoryCharacter) types[random.nextInt(types.length)].newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new Iterator<StoryCharacter>() {
            int count = size;

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public StoryCharacter next() {
                count--;
                return StoryCharacterGenerator.this.next();
            }
        };
    }
}

class StoryCharacter {

    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class GoodGuys extends StoryCharacter {
}

class BadGuys extends StoryCharacter {
}

class SpiderMan extends GoodGuys {

}

class Thor extends GoodGuys {

}

class Hulk extends GoodGuys {

}

class Chameleon extends BadGuys {

}

class Vulture extends BadGuys {

}

class Electro extends BadGuys {

}