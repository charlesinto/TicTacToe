package com.example.kazom.tictacto;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kazom on 04-Apr-18.
 */

public class Ai {
    private Random rand = new Random();
    private ArrayList<Integer> avaiableSpot;
    private int row;
    private int col;
    private TextView[][] games;
    public Ai(){

    }
    public void getGameSpot(TextView[][] games){
       while(true){
           this.row = Math.abs(rand.nextInt() % games[1].length);
           this.col = Math.abs(rand.nextInt() % games[1].length);
           if(games[row][col].getText().toString().equals("")){
               break;
           }
       }
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
}
