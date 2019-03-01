package ru.myachin.exceptions;

/**
 * 15. Продемонстрируйте, что прогармма <b>WithFinally.java</b> работает корректно при возбуждении
 * {@link RuntimeException} внутри блока <tt>try</tt>.
 */
public class WIthFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            try {
                sw.on();
                String s = args[2];
                OnOffSwitch.f();
            } catch (OnOffException1 onOffException1) {
                System.out.println("OnOffException1");
            } catch (OnOffException2 onOffException2) {
                System.out.println("OnOffException2");
            } finally {
                sw.off();
            }
        } catch (RuntimeException e) {
            System.out.println("The switch state is :" + sw);
        }
    }
}
