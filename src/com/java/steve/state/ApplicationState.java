package com.java.steve.state;

import com.java.steve.Command.ACommand;

public abstract class ApplicationState {

    public abstract void onCommand(String commandName);

    public abstract void enter(String commandName);

    public abstract void exit();


}
