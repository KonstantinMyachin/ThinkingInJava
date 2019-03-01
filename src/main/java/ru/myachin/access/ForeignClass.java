package ru.myachin.access;

import ru.myachin.access.local.AccessControl;
import ru.myachin.access.local.PackagedClass;

/**
 * @see PackagedClass
 * @see AccessControl
 */
public class ForeignClass {

    public static void main(String[] args) {
        PackagedClass packaged = new PackagedClass();
        //@see PackagedClass
        //System.out.println(packaged.s);

        AccessControl accessControl = new AccessControl();
        //@see AccessControl
        //accessControl.i1 = 1;
        //accessControl.i2 = 2;
        //accessControl.i3 = 3;
        accessControl.i4 = 4;

        //@see AccessControl
        //accessControl.privateMethod();
        //accessControl.packagePrivateMethod();
        //accessControl.protectedMethod();
        accessControl.publicMethod();
    }
}