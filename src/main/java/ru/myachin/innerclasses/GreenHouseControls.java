package ru.myachin.innerclasses;

import ru.myachin.innerclasses.controller.Controller;
import ru.myachin.innerclasses.controller.Event;

/**
 * 24. В программу {@link GreenHouseControls} добавьте внутренние классы для события {@link Event}, отключающие и
 * включающие проветривание оранжереи. Настройте программу {@link GreenHouseController} на использование нового типа
 * события.
 */
public class GreenHouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "День";
    private boolean fan = false;

    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Отключение";
        }
    }

    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Свет включен";
        }
    }

    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Свет выключен";
        }
    }

    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Полив включен";
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Полив выключен";
        }
    }

    public class ThermostatNight extends Event {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Ночь";
        }

        @Override
        public String toString() {
            return "Термостат использует ночной режим";
        }
    }

    public class ThermostatDay extends Event {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "День";
        }

        @Override
        public String toString() {
            return "Термостат использует дневной режим";
        }
    }

    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Бам!";
        }
    }

    public class Restart extends Event {

        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;

            for (Event e : eventList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);
            }

            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Перезапуск системы";
        }
    }

    public class FanOn extends Event {

        public FanOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = true;
        }

        @Override
        public String toString() {
            return "Проветривание включено";
        }
    }

    public class FanOff extends Event {

        public FanOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = false;
        }

        @Override
        public String toString() {
            return "Проветривание включено";
        }
    }
}