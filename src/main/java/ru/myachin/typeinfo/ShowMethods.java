package ru.myachin.typeinfo;

import net.mindview.util.Print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 17. Измените регулярное выражение в программе <tt>ShowMethods.java</tt> так, чтобы оно дополнительно выделяло
 * ключевые слова <tt>native</tt> и <tt>final</tt> (подсказка: используйте оператор ИЛИ - <tt>|</tt>)
 * <p>
 * 18. Отмените объевление {@link ShowMethods} как открытого <tt>public</tt> класса. Убедитесь в том, что
 * синтезированный конструктор по умолчанию пропадает из результатов.
 */
class ShowMethods {

    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";

    private static Pattern p = Pattern.compile("\\w+\\.|native\\s|final\\s");

    public static void main(String[] args) {
        if (args.length < 1) {
            Print.print(usage);
            System.exit(0);
        }

        int lines = 0;
        try {
            final Class<?> c = Class.forName(args[0]);
            final Method[] methods = c.getMethods();
            final Constructor<?>[] ctors = c.getConstructors();

            if (args.length == 1) {
                for (Method method : methods) {
                    Print.print(p.matcher(method.toString()).replaceAll(""));
                }

                for (Constructor<?> ctor : ctors) {
                    Print.print(p.matcher(ctor.toString()).replaceAll(""));
                }

                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        Print.print(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }

                for (Constructor<?> ctor : ctors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        Print.print(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            Print.print("No such class: " + e);
        }
    }
}
