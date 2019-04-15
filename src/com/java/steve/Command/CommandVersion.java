package com.java.steve.Command;

import static com.java.steve.Application.VERSION;

public class CommandVersion extends ACommand {
    public CommandVersion(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My version is " + VERSION);
    }
}
