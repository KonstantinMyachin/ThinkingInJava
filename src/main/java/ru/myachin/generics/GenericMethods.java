
package ru.myachin.generics;
/**
 * 9. Измените пример <tt>GenericMethods.java</tt>, чтобы метод <tt>f()</tt> получат три аргумента, относяющихся к
 * разным параметризованным типам.
 * <p>
 * 10. Измените предыдущее упражнение так, чтобы один из аргументов <tt>f()</tt> был непараметризованным.
 */
public class GenericMethods {

    public static void main(String[] args) {
        final GenericMethods g = new GenericMethods();
        g.f("a", "b", "c", 10);
        g.f(1.0f, 1.0d, 1, 10);
        g.f(true, 'c', (short) 1, 10);
    }

    public <A, B, C> void f(A a, B b, C c, int i) {
        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(c.getClass());
        System.out.println(i);
    }
}
