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


    }

    public static void changeState(ApplicationState newState, String commandName){
        currentState.exit();
        currentState = newState;
        currentState.enter(commandName);
    }

}
