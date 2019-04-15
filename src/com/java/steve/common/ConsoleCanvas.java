package com.java.steve.common;

public class ConsoleCanvas extends Canvas{


    @Override
    public void drawText(String text) {
        System.out.println("text");
    }

   @Override
    public void drawSquare(int size){
       System.out.println("\n");
       if(size<2) {
           System.out.println("Too small size");
       }
       for (int i = 0; i < size; i++) {
            System.out.print("#");

       }

       for (int i = 0; i < size-1; i++) {
           System.out.print("\n#");
           for (int j = 0; j < size-2; j++) {
               System.out.print(" ");

           }
           System.out.print("#");
       }
       System.out.println();

       for (int i = 0; i < size; i++) {
           System.out.print("#");

       }
       System.out.println();




    }

}
