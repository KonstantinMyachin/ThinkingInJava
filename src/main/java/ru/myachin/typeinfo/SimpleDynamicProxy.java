package ru.myachin.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 22. Измените пример <tt>SimpleDynamicProxy.java</tt>, чтобы в нем измерялось время вызова методов.
 * <p>
 * 23. Внутри метода <tt>invoke()</tt> из примера <tt>SimpleDynamicProxy.java</tt> попробуйте вывести
 * аргумент-заместитель. Объясните, что при этом происходит.
 */
public class SimpleDynamicProxy {

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        final Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }

    private static void consumer(Interface iFace) {
        iFace.doSomething();
        iFace.somethingElse("bonobo");
    }
}

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final long start = System.nanoTime();
        final Object invoke = method.invoke(proxied, args);
        final long end = System.nanoTime();
        System.out.println(String.format("Execution %s time = %d ms", method.getName(), end - start));
        //System.out.println(proxy); recursive invocation toString method
        return invoke;
    }
}