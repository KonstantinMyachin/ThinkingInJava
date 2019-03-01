package ru.myachin.innerclasses.secondpack;

import ru.myachin.innerclasses.fristpack.Interface;

/**
 * @see ru.myachin.innerclasses.ProtectedInnerClass
 */
public class Outer {

    protected class InnerClass implements Interface {

        public InnerClass() {
        }

        @Override
        public void doSomething() {
            System.out.println("InnerClass doSomething()");
        }
    }
}