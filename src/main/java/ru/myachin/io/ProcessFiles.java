package ru.myachin.io;

import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;

/**
 * 5. Измените код {@link net.mindview.util.ProcessFiles} так, чтобы вместо фиксированного расширения поиск
 * осуществлялся по регулярному выражение.
 */
public class ProcessFiles {

    private net.mindview.util.ProcessFiles.Strategy strategy;
    private String regex;

    public ProcessFiles(net.mindview.util.ProcessFiles.Strategy strategy,
                        String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else if (arg.matches(regex)) {
                        strategy.process(fileArg.getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        ProcessFiles process = new ProcessFiles(new net.mindview.util.ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*\\.java");

        process.start(args);
    }
}
