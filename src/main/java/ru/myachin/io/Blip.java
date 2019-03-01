package ru.myachin.io;

import net.mindview.io.Blip3;

import java.io.*;

/**
 * 29. В программе {@link Blip3} закомментируйте две строки после выражения <b>Обязательные действия</b> и запустите
 * программу. Объясните причину, по которой реузльтат ее работы отличается от того случая, когда обе закомментированные
 * строки выполняются.
 */
public class Blip extends Blip3 {

    public Blip() {
    }

    public Blip(String x, int a) {
        super(x, a);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip b3 = new Blip("A String ", 47);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip.out"));
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip) in.readObject();
        System.out.println(b3);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip.writeExternal()");
//        out.write(s);
//        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip.readExternal()");
//        s = (String) in.readObject();
//        i = in.readInt();
    }
}
