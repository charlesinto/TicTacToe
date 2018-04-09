package com.example.kazom.tictacto;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*
        *Created by Kazom on 04-Apr-18.
*/

public class Player {
    private TextView status;
    private int teamA = 0;
    private static int singlePlayerMode = 0;
    private static int smallBoard = 0;
    private AlertDialog.Builder mDialog;
    private static int largeBoard = 1;
    private int teamB = 0;
    private String player1 = "X";
    private String player2 = "O";
    private Context context;
    private String winner = "";
    private TextView[][] gameState;
    private String currentMaker = "";
    private int counter = 0;
    private MainActivity gamePlay;
    private int board;
    private int playerMode;
    private Ai ai;
    private int gameColor;

    public Player(int boardSize, int mode, String maker, Context context) {
        this.playerMode = mode;
        this.gamePlay = new MainActivity();
        this.board = boardSize;
        this.currentMaker = maker;
        this.context = context;
        ai = new Ai();
        mDialog = new AlertDialog.Builder(context);
    }
    public void inflateOutput(){
    }
    public TextView[][] playGame(TextView tile, TextView[][] gameState, TextView playerScore1, TextView playerScore2) {
        if (this.board == Player.smallBoard && this.winner.equals("")) {
            gamePlay(tile, gameState, playerScore1, playerScore2);
        } else if (this.board == Player.largeBoard && this.winner.equals("")) {
            gamePlay(tile, gameState, playerScore1, playerScore2);

        }


        return this.gameState;
    }

    public void gamePlay(TextView tile, TextView[][] gameState, TextView playerScore1, TextView playerScore2) {
        this.gameState = gameState;
        if (isMoveValid(tile)) {
            gameColor = this.currentMaker.equalsIgnoreCase(this.player1) ? Color.BLACK : Color.GREEN;
            tile.setText(this.currentMaker);
            tile.setTextColor(this.gameColor);
        }
        this.currentMaker = (this.currentMaker.equalsIgnoreCase(player1)) ? player2 : player1;
        //if single player mode, then computer should play
        if (this.playerMode == Player.singlePlayerMode) {
            if (isThereRemainingMove(gameState))
                computerPlay();
        }

        if (isThereAWinner(gameState, this.board)) {
           gamePlay.setWinner(true);
            this.counter++;
            if (this.winner.equalsIgnoreCase("X")){
                playerScore1.setText("" + ++this.teamA);
                gamePlay.setWhoWon(player1);
                //gamePlay.outputWinner();
                try{
                    this.status.setText("Player 1 Wins");

                }catch (NullPointerException e){

                }
            }else {
                playerScore2.setText("" + ++this.teamB);
                gamePlay.setWhoWon(player2);
                // gamePlay.outputWinner();
                try {
                    this.status.setText("Player 2 Wins");

                } catch (NullPointerException e) {

                }
            }


        }
        else{
            try{
                if(currentMaker.equalsIgnoreCase("X")){
                    this.status.setText("Player 1 Turn");
                }
                else{
                    this.status.setText("Player 2 Turn");
                }
            }catch (NullPointerException e){

            }
        }
        if (!isThereRemainingMove(gameState)) {
            if (!isThereAWinner(gameState, this.board))
                Toast.makeText(context, " Draw", Toast.LENGTH_SHORT).show();
                gamePlay.setWhoWon("Draw");
               //gamePlay.outputWinner();
            try{
                this.status.setText("Draw");

            }catch (NullPointerException e){

            }

        }
    }

    public boolean isMoveValid(TextView tile) {
        if (tile.getText().toString().equals(""))
            return true;
        else
            return false;
    }

    public boolean isThereRemainingMove(TextView[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j].getText().toString().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
    public void setStatus(TextView e){
        this.status = e;
    }
    public boolean isThereAWinner(TextView[][] game, int boardSize) {
       //Toast.makeText(context,""+ middleColL(),Toast.LENGTH_SHORT).show();
        switch (boardSize) {
            case 0:
            case -1:
                boolean diagonalAndMiddles = ((leftDiag() || rightDiag()) || (middleCol() || middleRow())) && !game[1][1].getText().toString().equals("");
                boolean firstRowAndCol = ((firstCol() || topRow()) && !game[0][0].getText().toString().equals(""));
                boolean lastRowAndCol = (secondCol() || lastRow()) && !game[2][2].getText().toString().equals("");
                if (diagonalAndMiddles) {
                    Toast.makeText(context, game[1][1].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[1][1].getText().toString();
                    return true;
                } else if (firstRowAndCol) {
                    Toast.makeText(context, game[0][0].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[0][0].getText().toString();
                    return true;
                } else if (lastRowAndCol) {
                    Toast.makeText(context, game[2][2].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[2][2].getText().toString();
                    return true;
                }
                break;
            case 1:
                boolean diagonalAndMiddle = ((leftDiagL() || rightDiagL()) || (middleColL() || middleRowL())) && !game[2][2].getText().toString().equals("");
                boolean firstRowAndCo = ((firstColL() || firstRowL()) && !game[0][0].getText().toString().equals(""));
                boolean lastRowAndCo = (fourthColL() || lastRowL()) && !game[4][4].getText().toString().equals("");
                boolean secondCol = secondColL() && !game[0][1].getText().toString().equals("");
                boolean thirdcol = thirdColL() && !game[0][3].getText().toString().equals("");
                boolean secondRow = secondRowL() && !game[1][0].getText().toString().equals("");
                boolean thirdRow = thirdRowL() && !game[3][0].getText().toString().equals("");
                if (diagonalAndMiddle) {
                    Toast.makeText(context, game[2][2].getText().toString() + "wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[2][2].getText().toString();
                    return true;
                } else if (firstRowAndCo) {
                    Toast.makeText(context, game[0][0].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[0][0].getText().toString();
                    return true;
                } else if (lastRowAndCo) {
                    Toast.makeText(context, game[4][4].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[4][4].getText().toString();
                    return true;
                } else if (secondCol) {
                    Toast.makeText(context, game[0][1].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[0][1].getText().toString();
                    return true;
                } else if (thirdcol) {
                    Toast.makeText(context, game[0][3].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[0][3].getText().toString();
                    return true;
                } else if (secondRow) {
                    Toast.makeText(context, game[1][0].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[1][0].getText().toString();
                    return true;
                } else if (thirdRow) {
                    Toast.makeText(context, game[3][0].getText().toString() + " wins", Toast.LENGTH_SHORT).show();
                    this.winner = game[3][0].getText().toString();
                    return true;
                }
                return false;
        }
        return false;
    }

    public void resetCounter() {
        this.teamB = 0;
        this.teamA = 0;
        this.counter = 0;
    }

    public boolean topRow() {
        return (this.gameState[0][0].getText().toString().equals(this.gameState[0][1].getText().toString())) &&
                (this.gameState[0][1].getText().toString().equals(this.gameState[0][2].getText().toString()));
    }

    public boolean firstCol() {
        return (this.gameState[0][0].getText().toString().equals(this.gameState[1][0].getText().toString())) &&
                (this.gameState[1][0].getText().toString().equals(this.gameState[2][0].getText().toString()));
    }

    public boolean leftDiag() {
        return (this.gameState[0][0].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[2][2].getText().toString()));
    }

    public boolean rightDiag() {
        return (this.gameState[0][2].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[2][0].getText().toString()));
    }

    public boolean middleCol() {
        return (this.gameState[0][1].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[2][1].getText().toString()));
    }

    public boolean secondCol() {
        return (this.gameState[0][2].getText().toString().equals(this.gameState[1][2].getText().toString())) &&
                (this.gameState[1][2].getText().toString().equals(this.gameState[2][2].getText().toString()));
    }

    public boolean middleRow() {
        return (this.gameState[1][0].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[1][2].getText().toString()));
    }

    public boolean lastRow() {
        return (this.gameState[2][0].getText().toString().equals(this.gameState[2][1].getText().toString())) &&
                (this.gameState[2][1].getText().toString().equals(this.gameState[2][2].getText().toString()));
    }

    public void computerPlay() {
        gameColor = this.currentMaker.equalsIgnoreCase(this.player1) ? Color.BLACK : Color.GREEN;
        ai.getGameSpot(gameState);
        gameState[ai.getRow()][ai.getCol()].setText(this.currentMaker);
        gameState[ai.getRow()][ai.getCol()].setTextColor(this.gameColor);
        this.currentMaker = (this.currentMaker.equalsIgnoreCase(player1)) ? player2 : player1;
    }

    public void setWinner(String empty) {
        this.winner = empty;
    }

    public boolean firstColL() {
        return (this.gameState[0][0].getText().toString().equals(this.gameState[1][0].getText().toString())) &&
                (this.gameState[1][0].getText().toString().equals(this.gameState[2][0].getText().toString()))
                && (this.gameState[2][0].getText().toString().equals(this.gameState[3][0].getText().toString())) &&
                (this.gameState[3][0].getText().toString().equals(this.gameState[4][0].getText().toString()));
    }

    public boolean leftDiagL() {
        return (this.gameState[0][0].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[2][2].getText().toString())) &&
                (this.gameState[2][2].getText().toString().equals(this.gameState[3][3].getText().toString()))
                && (this.gameState[3][3].getText().toString().equals(this.gameState[4][4].getText().toString()));
    }

    public boolean rightDiagL() {
        return (this.gameState[0][4].getText().toString().equals(this.gameState[1][3].getText().toString())) &&
                (this.gameState[1][3].getText().toString().equals(this.gameState[2][2].getText().toString()))
                && (this.gameState[2][2].getText().toString().equals(this.gameState[3][1].getText().toString()))
                && (this.gameState[3][1].getText().toString().equals(this.gameState[4][0].getText().toString()));
    }

    public boolean middleColL() {
        return (this.gameState[0][2].getText().toString().equals(this.gameState[1][2].getText().toString())) &&
                (this.gameState[1][2].getText().toString().equals(this.gameState[2][2].getText().toString()))
                && (this.gameState[2][2].getText().toString().equals(this.gameState[3][2].getText().toString())) &&
                (this.gameState[3][2].getText().toString().equals(this.gameState[4][2].getText().toString()));
    }

    public boolean secondColL() {
        return ((this.gameState[0][1].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[2][1].getText().toString())))
                && ((this.gameState[2][1].getText().toString().equals(this.gameState[3][1].getText().toString())) &&
                (this.gameState[3][1].getText().toString().equals(this.gameState[4][1].getText().toString())));
    }

    public boolean thirdColL() {
        return (this.gameState[0][3].getText().toString().equals(this.gameState[1][3].getText().toString())) &&
                (this.gameState[1][3].getText().toString().equals(this.gameState[2][3].getText().toString()))
                && (this.gameState[2][3].getText().toString().equals(this.gameState[3][3].getText().toString())) &&
                (this.gameState[3][3].getText().toString().equals(this.gameState[4][3].getText().toString()));
    }

    public boolean fourthColL() {
        return (this.gameState[0][4].getText().toString().equals(this.gameState[1][4].getText().toString())) &&
                (this.gameState[1][4].getText().toString().equals(this.gameState[2][4].getText().toString()))
                && (this.gameState[2][4].getText().toString().equals(this.gameState[3][4].getText().toString())) &&
                (this.gameState[3][4].getText().toString().equals(this.gameState[4][4].getText().toString()));
    }

    public boolean middleRowL() {
        return (this.gameState[2][0].getText().toString().equals(this.gameState[2][1].getText().toString())) &&
                (this.gameState[2][1].getText().toString().equals(this.gameState[2][2].getText().toString()))
                && (this.gameState[2][2].getText().toString().equals(this.gameState[2][3].getText().toString()))
                && (this.gameState[2][3].getText().toString().equals(this.gameState[2][4].getText().toString()));
    }

    public boolean lastRowL() {
        return (this.gameState[4][0].getText().toString().equals(this.gameState[4][1].getText().toString())) &&
                (this.gameState[4][1].getText().toString().equals(this.gameState[4][2].getText().toString()))
                && (this.gameState[4][2].getText().toString().equals(this.gameState[4][3].getText().toString()))
                && (this.gameState[4][3].getText().toString().equals(this.gameState[4][4].getText().toString()));
    }

    public boolean thirdRowL() {
        return (this.gameState[3][0].getText().toString().equals(this.gameState[3][1].getText().toString())) &&
                (this.gameState[3][1].getText().toString().equals(this.gameState[3][2].getText().toString()))
                && (this.gameState[3][2].getText().toString().equals(this.gameState[3][3].getText().toString()))
                && (this.gameState[3][3].getText().toString().equals(this.gameState[3][4].getText().toString()));
    }

    public boolean secondRowL() {
        return (this.gameState[1][0].getText().toString().equals(this.gameState[1][1].getText().toString())) &&
                (this.gameState[1][1].getText().toString().equals(this.gameState[1][2].getText().toString())) &&
                (this.gameState[1][2].getText().toString().equals(this.gameState[1][3].getText().toString()))
                && (this.gameState[1][3].getText().toString().equals(this.gameState[1][4].getText().toString()));
    }

    public boolean firstRowL() {
        return (this.gameState[0][0].getText().toString().equals(this.gameState[0][1].getText().toString())) &&
                (this.gameState[0][1].getText().toString().equals(this.gameState[0][2].getText().toString()))
                && (this.gameState[0][2].getText().toString().equals(this.gameState[0][3].getText().toString()))
                && (this.gameState[0][3].getText().toString().equals(this.gameState[0][4].getText().toString()));
    }
}
