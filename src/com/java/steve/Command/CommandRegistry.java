package com.java.steve.Command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum CommandRegistry {
    INSTANCE;

    static Map<String, ACommand> commands;

    static {
        commands = new HashMap<>();
        CommandAuthor commandAuthor = new CommandAuthor("author");
        commands.put("version", new CommandVersion("version"));
        commands.put("author", new CommandAuthor("author"));
        commands.put("creator", new CommandAuthor("author"));
        commands.put("father", new CommandAuthor("author"));
    }

    public ACommand getCommand(String name){
        return commands.get(name);
    }


    public void listCommands(){
        Iterator it = commands.entrySet().iterator();
        System.out.println("List of commmands:");

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println(entry.getKey());
        }
    }

    public boolean hasComamnd(String name){
        return commands.containsKey(name);
    }

}
