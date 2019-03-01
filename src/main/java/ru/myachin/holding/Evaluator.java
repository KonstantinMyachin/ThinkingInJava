package ru.myachin.holding;

import net.mindview.util.Stack;

/**
 * 15. Стеки часто используют для вычисления выражений в языках программирования. Используя реализацию {@link Stack},
 * вычислите результат следующего выражения, в котором <b>+</b> означает "занести следующую букву в стек", а <b>-</b> -
 * извлечь верхний элемент стека и вывести его.
 * <tt>+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---</tt>
 */
public class Evaluator {

    static final String INPUT = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";

    public static void main(String[] args) {
        System.out.println(evaluate(INPUT));
    }

    static String evaluate(final String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = chars.length; i < n; i++) {
            char c = chars[i];

            if (c == ' ') {
                sb.append(c);
            } else if (c == '+') {
                stack.push(chars[++i]);
            } else if (c == '-') {
                sb.append(stack.pop());
            }
        }

        return sb.toString();
    }
}
