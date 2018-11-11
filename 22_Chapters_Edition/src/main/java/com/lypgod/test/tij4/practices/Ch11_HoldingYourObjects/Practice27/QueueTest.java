package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liuyp on 16-10-13.
 */
class Command {
    Command(String command) {
        this.command = command;
    }

    private String command;

    void showCommand() {
        System.out.println(command);
    }
}

class Build {
    Queue<Command> makeQ() {
        Queue<Command> q = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            q.offer(new Command(i + " "));
        return q;
    }
}

public class QueueTest {
    public static void commandEater(Queue<Command> qc) {
        while (qc.peek() != null)
            qc.poll().showCommand();
    }

    public static void main(String[] args) {
        Build b = new Build();
        commandEater(b.makeQ());
    }
}
