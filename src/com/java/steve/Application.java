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
import com.java.steve.state.ApplicationState;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.StateIdle;

import javax.xml.crypto.Data;
import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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




    public static void main(String[] args) {




        ProfileController profileController = new ProfileController();
        profileController.showProfile(1);



    }

    public static void printList(List<String> list, String filter){
        for (String s : list) {
            if(s.matches(filter)){
                System.out.println(s);
            }

        }
    }

    public static void printList(List<String> list){
        for (String s : list) {

                System.out.println(s);


        }
    }

    public static void foreachCleanup(List<String> list, String filter){
        for (String s : list) {
            if(!s.matches(filter)){
                list.remove(s);
            }
        }
    }
//TODO
    public static void iteratorCleanup(List<String> list, String filter){
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(!s.matches(filter)){
              it.remove();
            }
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







    public static void changeState(ApplicationState newState, String commandName){
        currentState.exit();
        currentState = newState;
        currentState.enter(commandName);
    }

}


