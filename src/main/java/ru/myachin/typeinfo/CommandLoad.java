package ru.myachin.typeinfo;

/**
 * 7. Измените пример {@link net.mindview.typeinfo.SweetShop} так, чтобы тип создаваемых оъектов определялся аргументом
 * командной строки. Другими словами, если для запуска используется командная строка <tt>java SweetShop Candy</tt>, то
 * создаются только объекты {@link net.mindview.typeinfo.Candy}. Обратите внимание на возможность управления тем, какие
 * объекты {@link Class} загружаются программой, через аргумент командной строки.
 */
public class CommandLoad {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final int length = args.length;
        if (length != 1) {
            System.out.println("Usage: java SweetShop ClassName");
            System.exit(1);
        }

        final Class<?> c = Class.forName("ru.myachin.typeinfo." + args[0]);
        System.out.println(c.newInstance().getClass().getSimpleName());
    }
}

class Candy {

    static {
        System.out.println("Загрузка класса Candy");
    }
}

class Gum {

    static {
        System.out.println("Закгрузка класса Gum");
    }
}

class Cookie {

    static {
        System.out.println("Загрузка класса Cookie");
    }
}