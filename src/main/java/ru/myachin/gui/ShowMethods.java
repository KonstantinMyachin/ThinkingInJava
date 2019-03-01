package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 9. Взяв за отправную точку <tt>ShowAddListeners.java</tt>, создайте программу с полной функциональностью
 * {@link ru.myachin.typeinfo.ShowMethods}
 */
public class ShowMethods extends JFrame {

    private static Pattern pattern = Pattern.compile("\\w+\\.");
    private JTextField classNameField = new JTextField(20);
    private JTextField whatSearchField = new JTextField(20);
    private JTextArea resultTextArea = new JTextArea(20, 40);

    public ShowMethods() {
        classNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTextArea.setText("");
                String className = classNameField.getText();
                Class<?> aClass;
                try {
                    aClass = Class.forName(className);
                } catch (ClassNotFoundException e1) {
                    resultTextArea.setText("No match");
                    return;
                }

                final Method[] methods = aClass.getMethods();
                final Constructor<?>[] ctors = aClass.getConstructors();
                String wordToSearch = whatSearchField.getText();
                for (Constructor<?> ctor : ctors) {
                    String ctrDeclaration = ctor.toString();
                    if (wordToSearch != null && !wordToSearch.equals("")) {
                        if (ctrDeclaration.contains(wordToSearch)) {
                            resultTextArea.append(pattern.matcher(ctrDeclaration).replaceAll(""));
                            resultTextArea.append("\n");
                        }
                    } else {
                        resultTextArea.append(pattern.matcher(ctrDeclaration).replaceAll(""));
                        resultTextArea.append("\n");
                    }
                }

                for (Method method : methods) {
                    String methodDeclaration = method.toString();
                    if (wordToSearch != null && !wordToSearch.equals("")) {
                        if (methodDeclaration.contains(wordToSearch)) {
                            resultTextArea.append(pattern.matcher(methodDeclaration).replaceAll(""));
                            resultTextArea.append("\n");
                        }
                    } else {
                        resultTextArea.append(pattern.matcher(methodDeclaration).replaceAll(""));
                        resultTextArea.append("\n");
                    }
                }
            }
        });


        setLayout(new FlowLayout());

        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Class Name"));
        jPanel.add(classNameField);

        JPanel jPanel2 = new JPanel();
        jPanel2.add(new JLabel("Words To Search"));
        jPanel2.add(whatSearchField);

        add(jPanel);
        add(jPanel2);
        add(new JScrollPane(resultTextArea));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowMethods(), 500, 500);
    }
}
