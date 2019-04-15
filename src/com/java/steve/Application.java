package com.java.steve;

import com.java.steve.Command.ACommand;
import com.java.steve.Command.CommandRegistry;
import com.java.steve.profile.ProfileController;
import com.java.steve.profile.ProfileModel;
import com.java.steve.profile.ProfileView;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.StateIdle;

public class Application {

    static public final  String APP_NAME = "Steve";
    static public final String AUTHOR = "Aleksandr Lutkov";
    static public final String VERSION = "0.0.0";

    static ApplicationState currentState;

    public static void main(String[] args) {

        ProfileController profileController = new ProfileController();
        profileController.showProfile(5);









/*
//implementation of application States
        currentState = new StateIdle();
        changeState(new StateIdle(), "idle");
        currentState = new StateIdle();
        String commandName = "test command";
        currentState.onCommand(commandName);

        for (int i = 0; i < 10; i++) {
            currentState.onCommand(commandName+i);

        }
        System.out.println("Hello, my name is " + APP_NAME);
        System.out.println("My author's name is " + AUTHOR);

//implementation of class without sepatare description

        ACommand command = new ACommand("anonymous") {
            @Override
            public void execute() {
                System.out.println("Executing anonymous....");
            }
        };
        command.execute();

//initioal implementation if INSTANCE of objects

        String commandName = "version";
        ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
        command.execute();
        commandName = "creator";
        command = CommandRegistry.INSTANCE.getCommand(commandName);
        command.execute();
        CommandRegistry.INSTANCE.listCommands();
*/


    }

    public static void changeState(ApplicationState newState, String commandName){
        currentState.exit();
        currentState = newState;
        currentState.enter(commandName);
    }

}
