package com.java.steve.Command;

public class CommandHelp  extends ACommand{
    public CommandHelp(String name) {
        super(name);
    }

    @Override
    public void execute(){
        CommandRegistry.INSTANCE.listCommands();
    }
}
