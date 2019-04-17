package com.java.steve.common;

public class ConsoleCanvas extends Canvas{

    private char[][] pixes;
    private int width;
    private int height;

    public ConsoleCanvas(int width, int height){
        this.width = width;
        this.height = height;
        init();
    }

    public void init(){
        pixes = new char[height][width];
        reset();

    }

    private void reset(){
        for (int i=0; i<height; i++){
            for (int j = 0; j < width; j++) {
                pixes[i][j]='.';

            }
        }
    }

    public void draw(){
        for (int i=0; i<height; i++){
            System.out.print("\n");
            for (int j = 0; j < width; j++) {
                System.out.print(pixes[i][j]);

            }
        }
    }

    public void setSymbolAt(int x, int y, char symbol){
        pixes[x][y] = symbol;

    }

    public void drawSquareAt (int x, int y, int size){




        for (int i = y; i < y+size; i++) {
            pixes[x][i]='#';
        }

        for (int i = x; i < y+size-2; i++) {
            for (int j = y; j < y+size; j=j+size-1) {
                pixes[i][j]='#';
            }
        }

        for (int i = y; i < y+size; i++) {
            pixes[x+size-1][i]='#';
        }

/*

        for (int i = y; i < y+size; i++) {
            pixes[x][i]='#';
        }

        for (int i = x; i < y+size-2; i++) {
            for (int j = y; j < y+size; j=j+size-1) {
                pixes[i][j]='#';
            }
        }

        for (int i = y; i < y+size; i++) {
            pixes[x+size-1][i]='#';
        }
 */

    }


    public void drawCircleAt(int x, int y, int radius){

    }

    public void drawTextAt(int x, int y, String text){

    }

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
