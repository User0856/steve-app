package com.java.steve.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    Map<String, Table> tables;

    private Object tableLock = new Object();

    //DB.query("SELECT ID, NAME, EMAIL FROM CRIMINAL WHERE ID = ?");




    public void select(){

        System.out.println("Starting fetching records...");
        synchronized (tableLock){
        try {
            Thread.sleep(500);
            System.out.println("Finishing fetching records");
        } catch (InterruptedException e) {
        }
        }
    }

    public void update(){
        System.out.println("Starting updating records...");
        synchronized (tableLock){
        try {
            Thread.sleep(5000);
            System.out.println("Finishing updating records...");
        } catch (InterruptedException e) {
        }
        }
    }

    public static List<String[]> readDataFile(String fileName){
        FileInputStream fis = null;
        List<String[]> result = new ArrayList<>();
        BufferedReader br;
        try{
            fis = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
                result.add(line.split(";"));
            }
        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioex){
            ioex.printStackTrace();
        } finally{
            try{
                fis.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }


        return null;
    }


    public void delete(){

    }

    public void insert(Record record, Table table){

    }


}
