package ru.myachin.innerclasses;

import ru.myachin.innerclasses.controller.Event;

/**
 * 25. Унаследуйте от класса {@link GreenHouseControls}, чтобы добавить в него новый внутренний класс событий
 * {@link Event}, включающий и отключающий поддержку увлажнения оранжереи. Напишите новую версию программы
 * {@link GreenHouseController}, обеспечивающий поддержку нового типа события.
 */
public class GreenHouseControllerHumidification {

    public static void main(String[] args) {
        GreenHouseControlsHumidification gc = new GreenHouseControlsHumidification();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(300),
                gc.new LightOff(400),
                gc.new FanOff(500),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400),
                gc.new HumidificationOn(1600),
                gc.new HumidificationOff(1800)
        };

        gc.addEvent(gc.new Restart(2000, eventList));

        if (args.length == 1) {
            gc.addEvent(new GreenHouseControls.Terminate(new Integer(args[0])));
        }

        gc.run();

    }
}

class GreenHouseControlsHumidification extends GreenHouseControls {

    private boolean humidification = false;

    public class HumidificationOn extends Event {

        public HumidificationOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            humidification = true;
        }

        @Override
        public String toString() {
            return "Увлажнение оранжереи включено";
        }
    }

    public class HumidificationOff extends Event {

        public HumidificationOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            humidification = true;
        }

        @Override
        public String toString() {
            return "Увлажнение оранжереи выключено";
        }
    }
}
