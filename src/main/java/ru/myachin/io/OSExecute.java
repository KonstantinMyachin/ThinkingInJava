package ru.myachin.io;

import net.mindview.util.OSExecuteException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 22. Измените пример <tt>OSExecute.java</tt> так, чтобы вместо вывода стандартного потока результат выполнения
 * возвращался в виде списка {@link List} с элементами {@link String}. Продемонстрируйте использование новой версии
 * класса.
 */
public class OSExecute {

    private static List<String> out;

    public static List<String> command(String command) {
        boolean err = false;
        out = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                out.add(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }

        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }

        return out;
    }

    public static void main(String[] args) {
        List<String> result = command("mvn test");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
