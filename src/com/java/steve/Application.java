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
import java.util.List;

public class Application {

    static public final  String APP_NAME = "Steve";
    static public final String AUTHOR = "Aleksandr Lutkov";
    static public final String VERSION = "0.0.0";

    static ApplicationState currentState;

    public static void main(String[] args) {



        List<String[]> records = Database.readDataFile("////");

        Table table = new Table("Criminals", Arrays.asList(new String[]{"id", "name", "deceased"}));
        Database.readDataFile("///");

        for (String[] s : records) {
            Record rec = new Record(table);
            rec.setValues(s);
            table.insert(rec);
        }

        Record rec = new Record(table);
        rec.setValues(new String[]{"1", "Antony Saprano", "false"});
        try{
            System.out.println(rec.getInt("id"));
            System.out.println(rec.getBoolean("deceased"));
        } catch(Record.FieldNotFoundException ex){
            ex.printStackTrace();
        } catch(NumberFormatException nfe) {
            nfe.printStackTrace();

        }
        System.out.println("no execptions.");









    }

    public static void changeState(ApplicationState newState, String commandName){
        currentState.exit();
        currentState = newState;
        currentState.enter(commandName);
    }

}



//    ConsoleCanvas canvas = new ConsoleCanvas(15, 15);
//    canvas.drawTextAt(1, 2, "One morning Karl Weiss went out from his pretty german house in Baerlin, and he had no idea that it will be the last day of his life.");
//    canvas.draw();



/*
  Database db = new Database();
       Thread thread1 = new Thread(){
           @Override
           public void run(){
               try{
                   Thread.sleep(1000);
                   db.select();

               } catch (InterruptedException e){

               }
           }
       };

       Runnable runnable = new Runnable(){
           @Override
           public void run(){

                   db.update();

           }

       };

       thread1.start();
       (new Thread(runnable)).start();
 */




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
