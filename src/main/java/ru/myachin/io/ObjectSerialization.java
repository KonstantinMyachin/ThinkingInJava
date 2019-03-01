package ru.myachin.io;

import java.io.*;

/**
 * 27. Создайте класс, реализующий {@link Serializable}, содержащий ссылку на объект другого класса, реализующий
 * {@link Serializable}. Создайте экземпляр первого класса, сериализуйте его на диск, затем восстановите и убедитесь в
 * том, что процесс работает правильно.
 */
public class ObjectSerialization implements Serializable {

    private SerializableObject object = new SerializableObject();

    public void setObject(SerializableObject object) {
        this.object = object;
    }

    public static void main(String[] args) {
        ObjectSerialization obj = new ObjectSerialization();
        obj.setObject(new SerializableObject());
        try {
            String fileName = "objectSerialization.dat";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            try {
                oos.writeObject(obj);
                System.out.println(ois.readObject());
            } finally {
                oos.close();
                ois.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ObjectSerialization with object " + object.toString();
    }
}

class SerializableObject implements Serializable {

    private static int counter = 0;
    private final int id = ++counter;

    @Override
    public String toString() {
        return String.format("SerializableObject: %d", id);
    }
}