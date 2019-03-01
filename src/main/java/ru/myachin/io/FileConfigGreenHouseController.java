package ru.myachin.io;

import ru.myachin.innerclasses.GreenHouseControls;
import ru.myachin.innerclasses.controller.Event;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * 11. В примере {@link ru.myachin.innerclasses.GreenHouseController} содержит жестко запрограммированый набор событий.
 * Измените программу так, чтобы она читала события и их относительное время из тексового файла
 */
public class FileConfigGreenHouseController {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: configFilePath");
            System.exit(-1);
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String s;
            Class<?> gcClass = Class.forName("ru.myachin.innerclasses.GreenHouseControls");
            GreenHouseControls gc = ((GreenHouseControls) gcClass.newInstance());
            while ((s = reader.readLine()) != null) {
                String[] eventConfig = s.split(" ");
                Class<?> innerClass = Class.forName("ru.myachin.innerclasses.GreenHouseControls$" + eventConfig[0]);
                Constructor<?> ctor = innerClass.getDeclaredConstructor(gcClass, Long.class);

                Object event = ctor.newInstance(gc, Long.parseLong(eventConfig[1]));
                gc.addEvent((Event) event);
            }

            gc.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
