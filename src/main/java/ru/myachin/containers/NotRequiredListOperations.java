package ru.myachin.containers;

import java.util.*;

/**
 * 6. Контейнер {@link List} содержит дополнительные "необязательные" операции, не включенные в {@link Collection}.
 * Напишите версию <tt>Unsupported.java</tt> с проверкой этих дополнительных необязательных операций.
 */
public class NotRequiredListOperations {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        Unsupported.test("Modifiable Copy", new ArrayList<>(list));
        Unsupported.test("Arrays.asList()", list);
        Unsupported.test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
    }
}

class Unsupported {

    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }
        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }
        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }
        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
        try {
            list.add(0, "Test");
        } catch (Exception e) {
            System.out.println("add(index, element): " + e);
        }
        try {
            list.addAll(0, subList);
        } catch (Exception e) {
            System.out.println("addAll(index, c): " + e);
        }
        try {
            list.remove(0);
        } catch (Exception e) {
            System.out.println("remove(index): " + e);
        }
    }
}