package com.example.kazom.tictacto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isThereAWinner = false;
    private String whoWon = "";
    // 3 X 3
    private TextView tile1;
    private TextView tile2;
    private TextView tile3;
    private TextView tile4;
    private TextView tile5;
    private TextView tile6;
    private TextView tile7;
    private TextView tile8;
    private TextView tile9;

    // 5 X 5
    private TextView tile10;
    private TextView tile11;
    private TextView tile12;
    private TextView tile13;
    private TextView tile14;
    private TextView tile15;
    private TextView tile16;
    private TextView tile17;
    private TextView tile18;
    private TextView tile19;
    private TextView tile20;
    private TextView tile21;
    private TextView tile22;
    private TextView tile23;
    private TextView tile24;
    private TextView tile25;
    private Player player;

    private TextView[][] game;
    private AlertDialog.Builder mBuilder;
    private RadioGroup group1;
    private RadioGroup group2;
    private RadioGroup group3;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioButton btn3;
    private RadioButton btn4;
    private RadioButton btn5;
    private RadioButton btn6;
    private RadioButton btn7;
    private RadioButton btn8;
    private RadioButton btn9;
    private AlertDialog dialog;
    private Button start;
    private TextView mText;
    private TextView score1;
    private TextView score2;
    private Button restart;
    private Button reset;
    private AlertDialog.Builder winnerDialog;
    private String player1Maker = "X";
    private int boardSize = 0;
    private int maker = -1;
    private TextView status;
    private int mode = -1;
    private View vi;
    //private  View vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUserPrefence();
        // setMaker();
        if (boardSize == -1) {
            this.game = new TextView[3][3];
            setContentView(R.layout.small_grid);
            setTilesForSmall();
            player = new Player(0, 0, "X", getApplicationContext());
            setClickListenersForSmall();

        }



        //startActivity(new Intent(getApplicationContext(),small_grid.class));
    }
    public void setOutput(){
        AlertDialog.Builder g;
         g = new AlertDialog.Builder(MainActivity.this);
         View c = getOtputView();
         c = getLayoutInflater().inflate(R.layout.display_winner, null);
         TextView t = getOutputText();
        t = (TextView) vi.findViewById(R.id.wins);
        c.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    public TextView getOutputText(){
        return this.mText;
    }
    public AlertDialog.Builder getwinnnerDialog(){
        return this.winnerDialog;
    }
    public View getOtputView(){
        return this.vi;
    }
    public void  outputWinner(){
        setOutput();
        if(getWhoWon().equalsIgnoreCase("X")){
            getOutputText().setText("X - PLAYER 1 WINS");
        }
        else if(getWhoWon().equalsIgnoreCase("O")){
            getOutputText().setText("O - PLAYER 2 WINS");
        }
        else if(getWhoWon().equalsIgnoreCase("DRAW")){
            getOutputText().setText("DRAW");
        }
        getwinnnerDialog().setView(getOtputView());
        AlertDialog dialog = winnerDialog.create();
        dialog.show();
    }
    public void setWhoWon(String winner){
        this.whoWon = winner;
    }
    public String getWhoWon(){
        return this.whoWon;
    }
    public boolean isThereAWinner(){
        return this.isThereAWinner;
    }
    public void setWinner(boolean winner){
        this.isThereAWinner = winner;
    }
    public void setMaker() {

        player1Maker = (this.maker == 0) ? "X" : "O";
    }
    public boolean getWinner(){
        return this.isThereAWinner;
    }
    //output text that shows the if there is a winner, who's turn it and if there is a draw
    public TextView getStatus(){
        TextView e = this.status;
        return this.status;
    }
    /*
        set up 5x5 tiles
     */
    public void setTileForLarge() {
        status = (TextView) findViewById(R.id.status);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        this.reset = (Button) findViewById(R.id.reset);
        this.restart = (Button) findViewById(R.id.restart);
        this.tile1 = (TextView) findViewById(R.id.tile_1);
        this.tile2 = (TextView) findViewById(R.id.tile_2);
        this.tile3 = (TextView) findViewById(R.id.tile_3);
        this.tile4 = (TextView) findViewById(R.id.tile_4);
        this.tile5 = (TextView) findViewById(R.id.tile_5);
        this.tile6 = (TextView) findViewById(R.id.tile_6);
        this.tile7 = (TextView) findViewById(R.id.tile_7);
        this.tile8 = (TextView) findViewById(R.id.tile_8);
        this.tile9 = (TextView) findViewById(R.id.tile_9);
        this.tile10 = (TextView) findViewById(R.id.tile_10);
        this.tile11 = (TextView) findViewById(R.id.tile_11);
        this.tile12 = (TextView) findViewById(R.id.tile_12);
        this.tile13 = (TextView) findViewById(R.id.tile_13);
        this.tile14 = (TextView) findViewById(R.id.tile_14);
        this.tile15 = (TextView) findViewById(R.id.tile_15);
        this.tile16 = (TextView) findViewById(R.id.tile_16);
        this.tile17 = (TextView) findViewById(R.id.tile_17);
        this.tile18 = (TextView) findViewById(R.id.tile_18);
        this.tile19 = (TextView) findViewById(R.id.tile_19);
        this.tile20 = (TextView) findViewById(R.id.tile_20);
        this.tile21 = (TextView) findViewById(R.id.tile_21);
        this.tile22 = (TextView) findViewById(R.id.tile_22);
        this.tile23 = (TextView) findViewById(R.id.tile_23);
        this.tile24 = (TextView) findViewById(R.id.tile_24);
        this.tile25 = (TextView) findViewById(R.id.tile_25);
        initializeGame();
//        this.gameSate.add(tile1);
//        this.gameSate.add(tile2);
//        this.gameSate.add(tile3);
//        this.gameSate.add(tile4);
//        this.gameSate.add(tile5);
//        this.gameSate.add(tile6);
//        this.gameSate.add(tile7);
//        this.gameSate.add(tile8);
//        this.gameSate.add(tile9);    th

    }
    public void initializeGame(){

        this.game[0][0] = this.tile1;
        this.game[0][1] = this.tile2;
        this.game[0][2] = this.tile3;
        this.game[0][3] = this.tile4;
        this.game[0][4] = this.tile5;
        this.game[1][0] = this.tile6;
        this.game[1][1] = this.tile7;
        this.game[1][2] = this.tile8;
        this.game[1][3] = this.tile9;
        this.game[1][4] = this.tile10;
        this.game[2][0] = this.tile11;
        this.game[2][1] = this.tile12;
        this.game[2][2] = this.tile13;
        this.game[2][3] = this.tile14;
        this.game[2][4] = this.tile15;
        this.game[3][0] = this.tile16;
        this.game[3][1] = this.tile17;
        this.game[3][2] = this.tile18;
        this.game[3][3] = this.tile19;
        this.game[3][4] = this.tile20;
        this.game[4][0] = this.tile21;
        this.game[4][1] = this.tile22;
        this.game[4][2] = this.tile23;
        this.game[4][3] = this.tile24;
        this.game[4][4] = this.tile25;
    }
    public void getUserPrefence() {
        this.mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mview = getLayoutInflater().inflate(R.layout.user_preference, null);
        this.group1 = (RadioGroup) mview.findViewById(R.id.rg1);
        this.group2 = (RadioGroup) mview.findViewById(R.id.rg2);
        this.group3 = (RadioGroup) mview.findViewById(R.id.rg3);

        this.btn1 = (RadioButton) mview.findViewById(R.id.rb1);
        this.btn2 = (RadioButton) mview.findViewById(R.id.rb2);
        this.btn3 = (RadioButton) mview.findViewById(R.id.rb3);
        this.btn4 = (RadioButton) mview.findViewById(R.id.rb4);
        this.btn5 = (RadioButton) mview.findViewById(R.id.rb5);
        this.btn6 = (RadioButton) mview.findViewById(R.id.rb6);
        this.start = (Button) mview.findViewById(R.id.startGame);

        this.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMaker();
                setGame();
                dialog.dismiss();
            }
        });
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb1:
                        mode = 0;
                        break;
                    case R.id.rb2:
                        mode = 1;
                        break;

                }
            }

        });
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb3:
                        boardSize = 0;
                        break;
                    case R.id.rb4:
                        boardSize = 1;
                        break;
                }
            }
        });
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb5:
                        maker = 0;
                        break;
                    case R.id.rb6:
                        maker = 1;
                        break;
                }
            }
        });
        //setOutput();
        this.mBuilder.setView(mview);
        dialog = this.mBuilder.create();
        dialog.show();
    }
    /*
        set game according to user preferences
     */
    public void setGame() {
        if (this.boardSize == 0) {
            this.game = new TextView[3][3];
            setContentView(R.layout.small_grid);
            setTilesForSmall();
            player = new Player(this.boardSize, this.mode, this.player1Maker, getApplicationContext());
            player.setStatus(this.status);
            setClickListenersForSmall();
        }
        else if (this.boardSize == 1){
            this.game = new TextView[5][5];
            setContentView(R.layout.large_grid);
            player = new Player(this.boardSize, this.mode, this.player1Maker, getApplicationContext());
            setTileForLarge();
            setClickListenersForLarge();
        }
    }
    /*
        set up tiles for small grid
     */
    private void setTilesForSmall() {

        status = (TextView) findViewById(R.id.status);

        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        this.reset = (Button) findViewById(R.id.reset);
        this.restart = (Button) findViewById(R.id.restart);
        this.tile1 = (TextView) findViewById(R.id.tile_1);
        this.tile2 = (TextView) findViewById(R.id.tile_2);
        this.tile3 = (TextView) findViewById(R.id.tile_3);
        this.tile4 = (TextView) findViewById(R.id.tile_4);
        this.tile5 = (TextView) findViewById(R.id.tile_5);
        this.tile6 = (TextView) findViewById(R.id.tile_6);
        this.tile7 = (TextView) findViewById(R.id.tile_7);
        this.tile8 = (TextView) findViewById(R.id.tile_8);
        this.tile9 = (TextView) findViewById(R.id.tile_9);
//        this.gameSate.add(tile1);
//        this.gameSate.add(tile2);
//        this.gameSate.add(tile3);
//        this.gameSate.add(tile4);
//        this.gameSate.add(tile5);
//        this.gameSate.add(tile6);
//        this.gameSate.add(tile7);
//        this.gameSate.add(tile8);
//        this.gameSate.add(tile9);
        this.game[0][0] = this.tile1;
        this.game[0][1] = this.tile2;
        this.game[0][2] = this.tile3;
        this.game[1][0] = this.tile4;
        this.game[1][1] = this.tile5;
        this.game[1][2] = this.tile6;
        this.game[2][0] = this.tile7;
        this.game[2][1] = this.tile8;
        this.game[2][2] = this.tile9;
    }
    /*
       Add click listeners to 3x3 tiles
     */
    public void setClickListenersForSmall() {

        this.tile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile1, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile2, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile3, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile4, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile5, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile6, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    game = player.playGame(tile7, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    player.playGame(tile8, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.tile9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner)
                    player.playGame(tile9, game, score1, score2);
                else{
                    outputWinner();
                }
            }
        });
        this.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        this.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });
    }
    /*
        Add onclick listeners to 5x5
     */
    public void setClickListenersForLarge() {
        this.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        this.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });
        this.tile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile1, game, score1, score2);
            }
        });
        this.tile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile2, game, score1, score2);
            }
        });
        this.tile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile3, game, score1, score2);
            }
        });
        this.tile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile4, game, score1, score2);
            }
        });
        this.tile5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile5, game, score1, score2);
            }
        });
        this.tile6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile6, game, score1, score2);
            }
        });
        this.tile7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile7, game, score1, score2);
            }
        });
        this.tile8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile8, game, score1, score2);
            }
        });
        this.tile9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile9, game, score1, score2);
            }
        });
        this.tile10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile10, game, score1, score2);
            }
        });
        this.tile11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                 game = player.playGame(tile11, game, score1, score2);
            }
        });
        this.tile12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile12, game, score1, score2);
            }
        });
        this.tile13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile13, game, score1, score2);
            }
        });
        this.tile14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile14, game, score1, score2);
            }
        });
        this.tile15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game = player.playGame(tile15, game, score1, score2);
            }
        });
        this.tile16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile16, game, score1, score2);
            }
        });
        this.tile17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile17, game, score1, score2);
            }
        });
        this.tile18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile18, game, score1, score2);
            }
        });
        this.tile19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile19, game, score1, score2);
            }
        });
        this.tile20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile20, game, score1, score2);
            }
        });
        this.tile21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile21, game, score1, score2);
            }
        });
        this.tile22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile22, game, score1, score2);
            }
        });
        this.tile23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile23, game, score1, score2);
            }
        });
        this.tile24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile24, game, score1, score2);
            }
        });
        this.tile25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isThereAWinner())
                    game = player.playGame(tile25, game, score1, score2);
            }
        });
    }

    public void resetGame() {
        this.status.setText("");
        player.setWinner("");
        try{
            for (int i = 0; i < this.game.length; i++) {
                for (int j = 0; j < this.game[i].length; j++) {
                    this.game[i][j].setText("");
                }
            }
        }catch(Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        //outputWinner();

    }

    public void restartGame() {
        resetGame();
        score1.setText("0");
        score2.setText("0");
        player.resetCounter();
        this.dialog.show();
    }
}
