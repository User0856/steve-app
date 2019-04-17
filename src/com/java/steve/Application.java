package com.java.steve;

import com.java.steve.Command.ACommand;
import com.java.steve.Command.CommandRegistry;
import com.java.steve.common.ConsoleCanvas;
import com.java.steve.db.Record;
import com.java.steve.db.Table;
import com.java.steve.profile.ProfileController;
import com.java.steve.profile.ProfileModel;
import com.java.steve.profile.ProfileView;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.ApplicationState;
import com.java.steve.state.StateIdle;

import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static public final  String APP_NAME = "Steve";
    static public final String AUTHOR = "Aleksandr Lutkov";
    static public final String VERSION = "0.0.0";

    static ApplicationState currentState;

    public static void main(String[] args) {


        List<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("fastName");
        columns.add("lastName");
        Table criminalTable = new Table("criminals", columns);
        List<String> values = new ArrayList<>();
        List<String> values2 = new ArrayList<>();
        values.add("1");
        values.add("Steve");
        values.add("Balmer");

        values2.add("2");
        values2.add("Karl");
        values2.add("Balmer+");

        Record criminal = new Record(values);
//        Record criminal2 = new Record(values2);
        criminalTable.insert(new Record(values));
        criminalTable.insert(new Record(values2));


        List<String> result = criminalTable.selectField("id");

        for (String s : result) {
            System.out.println(s);
        }




        /*

                Runnable thread = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 20; i++) {
                    System.out.print(".");
                    try{
                        Thread.sleep(500);
//                        System.out.println(this.getState());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("done");
            }
        };
        System.out.println("\nloading");


        ((Thread) thread).start();






        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("-");
                    try{
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
         */

    }

    public static void changeState(ApplicationState newState, String commandName){
        currentState.exit();
        currentState = newState;
        currentState.enter(commandName);
    }

}
