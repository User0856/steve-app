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

    /*
    + - 1 time or more
    * - - times or more
    *     public static final String ALLOWED_DOMAIN_NAMES = "^([a-zA-Z0-9]+\\.)+[a-zA-Z]+$";
     */

    public static final String ALLOWED_DOMAIN_NAMES = "^([a-zA-Z0-9]+\\.)+(com|de|ru)$";

    //"SELECT id, firstName, lastName, FROM Criminals"

    public static final String OP_GROUP = "^(SELECT|DELETE)";
    public static  final String FLD_GROUP = "([a-zA-Z, ]+)";
    public static final String SPACE = "([\\s]+)";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TBL_GROUP = "([a-zA-Z]+)$";




    public static void main(String[] args) {

        String query = "SELECT id, firstName, lastName, FROM Criminals";

        Pattern p = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP);
        Matcher matcher = p.matcher(query);
        if(matcher.find()){
            System.out.println("Number of groups: " + matcher.groupCount());
            for (int i = 0, len = matcher.groupCount(); i <= len; i++) {
                System.out.println(matcher.group(i));
            }
        }

        //Profilecontroller show



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






/*
        List<String> list = new ArrayList<>();
        list.add("developer.apple.com");
        list.add("google.com");
        list.add("wrong");
        list.add(".another");
        list.add("this is wrong domain name");
        list.add("facebook.com");
        list.add("nasa.gov");
        list.add("handlelsblatt.de");
        list.add("login.cinoodials.elpais.com");
        list.add("yandex.ru");
        list.add("mail.ru");


        iteratorCleanup(list, ALLOWED_DOMAIN_NAMES);
        printList(list);
 */

















/*
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


 */


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
