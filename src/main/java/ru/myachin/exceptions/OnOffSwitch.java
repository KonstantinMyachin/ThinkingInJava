package ru.myachin.exceptions;

/**
 * 14. Покажите, что программа <b>OnOffSwitch.java</b> может завершиться сбоем при возбуждении {@link RuntimeException}
 * внутри блока <tt>try</tt>.
 */
public class OnOffSwitch {
    static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {

    }

    public static void main(String[] args) {
        try {
            try {
                sw.on();
                f();
                String s = args[2];
                sw.off();
            } catch (OnOffException1 onOffException1) {
                System.out.println("OnOffException1");
                sw.off();
            } catch (OnOffException2 onOffException2) {
                System.out.println("OnOffException2");
                sw.off();
            }
        } catch (RuntimeException e) {
            System.out.println("The switcher state is :" + sw);
        }
    }
}

class OnOffException1 extends Exception {

}

class OnOffException2 extends Exception {

}
