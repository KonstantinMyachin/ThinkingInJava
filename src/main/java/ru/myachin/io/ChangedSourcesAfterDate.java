package ru.myachin.io;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * 6. Используйте {@link ProcessFiles} для поиска в заданном поддереве каталогов всех файлов с исходным кодом
 * <tt>Java</tt>, измененных после конкретной даты
 */
public class ChangedSourcesAfterDate {

    private final ProcessFiles process;

    private ChangedSourcesAfterDate(Date changedAfter) {
        process = new ProcessFiles(new net.mindview.util.ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                if (file.lastModified() > changedAfter.getTime()) {
                    System.out.println(file.getName());
                }
            }
        }, ".*\\.java");
    }

    private ProcessFiles getProcess() {
        return process;
    }

    public static void main(String[] args) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.MONTH, -1);
        ChangedSourcesAfterDate changedSourcesAfterDate = new ChangedSourcesAfterDate(currentDate.getTime());
        changedSourcesAfterDate.getProcess().start(args);
    }
}
