package com.lypgod.test.tij4.practices.Ch18_IO.Practice33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

public class PreferencesDemo {
    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        int value = prefs.getInt("base directory", 0);
        System.out.print("Base directory value = " + value + "\nEnter new base directory value (integer): ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            value = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(1);
        }
        prefs.putInt("base directory", value);
    }
}
