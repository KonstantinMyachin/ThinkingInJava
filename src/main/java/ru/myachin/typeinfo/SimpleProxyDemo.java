package ru.myachin.typeinfo;

/**
 * 21. Измените пример <tt>SimpleProxyDemo.java</tt>, чтобы в нем измерялось время вызова методов
 */
public class SimpleProxyDemo {

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }

    public static void consumer(Interface iFace) {
        iFace.doSomething();
        iFace.somethingElse("bonobo");
    }
}

interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println(String.format("somethingElse %s", arg));
    }
}

class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        long start = System.nanoTime();
        proxied.doSomething();
        long end = System.nanoTime();
        System.out.println("Execution doSomething time = " + (end - start) + " ms");
    }

    @Override
    public void somethingElse(String arg) {
        long start = System.nanoTime();
        proxied.somethingElse(arg);
        long end = System.nanoTime();
        System.out.println("Execution somethingElse time = " + (end - start) + " ms");
    }
}