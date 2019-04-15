package com.java.steve.Command;

import static com.java.steve.Application.AUTHOR;

public class CommandAuthor extends ACommand {
    public CommandAuthor(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My author is " + AUTHOR);
    }
}
