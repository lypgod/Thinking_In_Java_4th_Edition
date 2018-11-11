//: net/mindview/util/OSExecute.java
// Run an operating system command
// and send the output to the console.
package com.lypgod.test.tij4.practices.Ch18_IO.Practice22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}

public class OSExecute {
    public static List<String> command(String command) {
        boolean err = false;
        List<String> ls = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null)
                ls.add(s);
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value
            // to calling process if there are problems:
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            // Compensate for Windows 2000, which throws an
            // exception for the default command line:
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing " + command);
        return ls;
    }

    public static void main(String[] args) {
        for (String s : OSExecute.command("javap OSExecute22Test"))
            System.out.println(s);
    }
} ///:~
