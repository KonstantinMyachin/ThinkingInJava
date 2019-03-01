package ru.myachin.generics;

import net.mindview.util.Generator;

import java.util.*;

/**
 * 13. Перегрузите метод {@link net.mindview.generics.Generators#fill(Collection, Generator, int)} так, чтобы аргументы
 * и возвращаемые типы были конкретными подтипами {@link Collection}: {@link List}, {@link Queue} и {@link Set}. При
 * этом информация о типе контейнера не теряется. Сможет ли перегруженная версия различать {@link List} и
 * {@link LinkedList}?
 */
public class OverloadedFillMethod {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(generator.next());
        }

        return coll;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            list.add(generator.next());
        }

        return list;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> list, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            list.add(generator.next());
        }

        return list;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            set.add(generator.next());
        }

        return set;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            queue.add(generator.next());
        }

        return queue;
    }

    public static void main(String[] args) {
        final StoryCharacterGenerator generator = new StoryCharacterGenerator();
        final List<StoryCharacter> characterList = fill(new ArrayList<>(), generator, 5);
        final List<StoryCharacter> characterLinkedList = fill(new LinkedList<>(), generator, 5);
        final Set<StoryCharacter> characterSet = fill(new HashSet<>(), generator, 5);
        final Queue<StoryCharacter> characterQueue =
                fill(((Queue<StoryCharacter>) new LinkedList<StoryCharacter>()), new StoryCharacterGenerator(), 5);

        printCollection(characterList);
        printCollection(characterLinkedList);
        printCollection(characterSet);
        printCollection(characterQueue);
    }

    private static <T> void printCollection(Collection<T> collection) {
        for (T t : collection) {
            System.out.println(t);
        }

        System.out.println();
    }
}
