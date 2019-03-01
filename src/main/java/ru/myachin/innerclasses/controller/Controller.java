package ru.myachin.innerclasses.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Controller {

//@see GreenHouseController
//    private List<Event> eventList = new ArrayList<>();

    private List<Event> eventList = new LinkedList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        //@see GreenHouseController
/*        while (eventList.size() > 0) {
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }*/

        while (eventList.size() > 0) {
            Iterator<Event> iterator = new LinkedList<>(eventList).iterator();
            while (iterator.hasNext()) {
                Event e = iterator.next();
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}