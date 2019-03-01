package ru.myachin.io;

import java.util.Scanner;
import java.util.prefs.Preferences;

public class DemonstratePreferencesAPI {

    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(DemonstratePreferencesAPI.class);
        String directory = prefs.get("base directory", "Not defined");
        System.out.println("directory: " + directory);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a new directory: ");
        directory = sc.nextLine();
        prefs.put("base directory", directory);
        System.out.println("directory: " + directory);
    }
}
