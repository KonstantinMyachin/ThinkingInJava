package ru.myachin.interfaces;

interface InterfaceStaticFinal {

    String JAVA = "JAVA";
}

/**
 * 17. Покажите, что поля интерфейса автоматически являются статическими <b>(static)</b> и неизменными <b>(final)</b>.
 */
public class StaticFinalInterfaceFields {

    public static void main(String[] args) {
        System.out.println(InterfaceStaticFinal.JAVA); //only static variables might be used in static method;
//        InterfaceStaticFinal.JAVA = new String(); compile error: cannot assign a new value to static variable
    }
}