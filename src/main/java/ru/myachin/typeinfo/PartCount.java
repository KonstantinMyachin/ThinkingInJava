package ru.myachin.typeinfo;

import net.mindview.typeinfo.Part;
import net.mindview.util.TypeCounter;

public class PartCount {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        for(int i = 0; i < 20; i++) {
            Part part = Part.createRandom();
            System.out.println(part);
            counter.count(part);
        }

        System.out.println(counter);
    }
}