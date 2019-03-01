package ru.myachin.generics;

import net.mindview.util.Tuple;
import net.mindview.util.TwoTuple;

import java.awt.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 39. Добавьте в <tt>DynamicProxyMixin.java</tt> новый класс примеси {@link Colored}. Продемонстрируйте, что он
 * работает
 */
public class DynamicProxyMixin {

    public static void main(String[] args) {
        final Object mixin = MixinProxy.newInstance(
                Tuple.tuple(new BasicImpl(), Basic.class),
                Tuple.tuple(new TimeStampedImpl(), TimeStamped.class),
                Tuple.tuple(new SerialNumberedImpl(), SerialNumbered.class),
                Tuple.tuple(new ColoredImpl(), Colored.class)
        );

        Basic b = ((Basic) mixin);
        final TimeStamped t = (TimeStamped) mixin;
        final SerialNumbered s = (SerialNumbered) mixin;
        final Colored c = (Colored) mixin;
        b.set("Hello");
        c.setColor(Color.BLACK);
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        System.out.println(c.getColor());
    }
}

class MixinProxy implements InvocationHandler {

    Map<String, Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();

        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                final String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = ((Class) pairs[i].second);
        }

        final ClassLoader cl = pairs[0].first.getClass().getClassLoader();

        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String methodName = method.getName();
        final Object delegate = delegatesByMethod.get(methodName);

        return method.invoke(delegate, args);
    }
}
