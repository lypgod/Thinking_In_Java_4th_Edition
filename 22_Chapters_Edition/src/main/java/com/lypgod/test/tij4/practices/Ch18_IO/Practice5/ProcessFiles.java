//: net/mindview/util/ProcessFiles.java
package com.lypgod.test.tij4.practices.Ch18_IO.Practice5;

import com.lypgod.test.tij4.practices.Ch18_IO.Directory;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProcessFiles {
    private Strategy strategy;
    private String regex;
    public ProcessFiles(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*D.*").start(args);
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        Pattern pattern = Pattern.compile(regex);
                        if (pattern.matcher(arg).matches())
                            strategy.process(new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }

    public interface Strategy {
        void process(File file);
    }
}
