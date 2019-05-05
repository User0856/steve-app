package com.java.steve;

import com.java.steve.Command.ACommand;
import com.java.steve.Command.CommandRegistry;
import com.java.steve.common.ConsoleCanvas;
import com.java.steve.db.Database;
import com.java.steve.db.Record;
import com.java.steve.db.Table;
import com.java.steve.profile.ProfileController;
import com.java.steve.profile.ProfileModel;
import com.java.steve.profile.ProfileView;
import com.java.steve.server.AppServer;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.StateIdle;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.chrono.ThaiBuddhistEra;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    static public final  String APP_NAME = "Steve";
    static public final String AUTHOR = "Aleksandr Lutkov";
    static public final String VERSION = "0.0.0";

    static ApplicationState currentState;

    public static final String ALLOWED_DOMAIN_NAMES = "^([a-zA-Z0-9]+\\.)+(com|de|ru)$";
    public static final String OP_GROUP = "^(SELECT|DELETE)";
    public static  final String FLD_GROUP = "([a-zA-Z, ]+)";
    public static final String SPACE = "([\\s]+)";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TBL_GROUP = "([a-zA-Z]+)$";


    public static void main(String[] args) throws IOException {


        AppServer.INSTANCE.start();



        Scanner sc = new Scanner(System.in);
        String name;
        while (sc.hasNext()){
            name = sc.next();
            if(CommandRegistry.INSTANCE.hasCommand(name)){
                ACommand command = CommandRegistry.INSTANCE.getCommand(name);
                command.execute();
            } else {
                System.out.println("Command \"" + name + "\" not implemented");
            }
        }




        ProfileController profileController = new ProfileController();
        profileController.showProfile(1);



    }


    public static void changeState(ApplicationState newState, String commandName){
        currentState.exit();
        currentState = newState;
        currentState.enter(commandName);
    }

}



            /*
                String query = "SELECT id, firstName, lastName, FROM Criminals";

        Pattern p = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP);
        Matcher matcher = p.matcher(query);
        if(matcher.find()){
            System.out.println("Number of groups: " + matcher.groupCount());
            for (int i = 0, len = matcher.groupCount(); i <= len; i++) {
                System.out.println(matcher.group(i));
            }
        }
         */
