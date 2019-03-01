package ru.myachin.innerclasses;

import ru.myachin.innerclasses.controller.Event;

/**
 * 13. В примере {@link GreenHouseController} класс {@link ru.myachin.innerclasses.controller.Controller} использует
 * {@link java.util.ArrayList}.Измените код так, чтобы в нем использовался класс {@link java.util.LinkedList}, и
 * организуйте перебор событий с использование {@link java.util.Iterator}
 *
 * @see ru.myachin.innerclasses.controller.Controller
 */
public class GreenHouseController {

    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(300),
                gc.new LightOff(400),
                gc.new FanOff(500),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };

        gc.addEvent(gc.new Restart(2000, eventList));

        if (args.length == 1) {
            gc.addEvent(new GreenHouseControls.Terminate(new Integer(args[0])));
        }

        gc.run();
    }
}