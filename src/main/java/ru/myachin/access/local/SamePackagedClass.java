package ru.myachin.access.local;

/**
 * @see PackagedClass
 * @see AccessControl
 */
public class SamePackagedClass {

    public static void main(String[] args) {
        PackagedClass packaged = new PackagedClass();
        packaged.s = "Protected Attribute Initialization";
        System.out.println(packaged.s);

        AccessControl accessControl = new AccessControl();
        //@see AccessControl
        //accessControl.i1 = 1;
        accessControl.i2 = 2;
        accessControl.i3 = 3;
        accessControl.i4 = 4;

        //@see AccessControl
        //accessControl.privateMethod();
        accessControl.packagePrivateMethod();
        accessControl.protectedMethod();
        accessControl.publicMethod();
    }
}
