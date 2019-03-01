package ru.myachin.access;

/**
 * 8. По образцу примера <b>Lunch.java</b> создайте класс с именем <b>ConnectionManager</b>, который управляет
 * фиксированным массивом объектов {@link Connection}. Программист-клиент не должен напрямую создавать объекты
 * {@link Connection}, а может получить их только с помощью статического метода класса {@link ConnectionManager}.
 * Когда запас объектов у класса {@link ConnectionManager} будет исчерпан, он должен вернуть ссылку <tt>null</tt>.
 * Протестируйте классы в методе {@link #main(String[])}
 */
public class ConnectionManager {

    private static Connection[] connections = new Connection[]{
            new Connection(),
            new Connection(),
            new Connection()
    };

    private static int freeConnections = connections.length;

    public static Connection getConnection() {
        if (freeConnections != 0) {
            return connections[connections.length - freeConnections--];
        }

        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(getConnection());
        }
    }
}

class Connection {

    Connection() {

    }
}
