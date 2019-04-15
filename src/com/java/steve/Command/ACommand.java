package com.java.steve.Command;

public abstract class ACommand {
    private String name;
    private String description;

    public ACommand(String name){
        this.name = name;
    }

    public void execute(){
        System.out.println("Command \"" + name + "\" not implemented");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
