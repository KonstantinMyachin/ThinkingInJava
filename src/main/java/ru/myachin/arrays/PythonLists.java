package ru.myachin.arrays;

import java.util.*;

/**
 * 25. Перепишите пример <tt>PythonLists.py</tt> на <tt>Java</tt>.
 */
public class PythonLists {

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(aList.getClass().getSimpleName());
        System.out.println(aList);
        System.out.println(aList.get(4));
        aList.add(6);
        aList.addAll(Arrays.asList(7, 8));
        System.out.println(aList);
        final List<Integer> aSlice = aList.subList(2, 4);
        System.out.println(aSlice);

        List<Integer> list2 = new MyList<>(aList);
        System.out.println(list2.getClass().getSimpleName());
        System.out.println(((MyList<Integer>) list2).getReversed());
    }
}

class MyList<T> extends ArrayList<T> {

    MyList(Collection<? extends T> c) {
        super(c);
    }

    List<T> getReversed() {
        MyList<T> reversed = new MyList<>(this);
        Collections.sort(reversed, Collections.reverseOrder());

        return reversed;
    }
}