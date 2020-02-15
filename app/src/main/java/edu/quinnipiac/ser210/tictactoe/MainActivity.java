package edu.quinnipiac.ser210.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //Instance Variables
    private String name = "";
    private TicTacToe board = new TicTacToe();
    private int currentState = ITicTacToe.PLAYING;

    //Message displayed at top of the screen
    private TextView messageView;

    //Button used to reset the board at the end of each game
    public Button resetBtn;

    //Holder buttons for the player/computer selection
    public Button playerBtn, compBtn;

    //Array containing every button in the view
    private Button[] buttons = new Button[9];
    private int cx;
    private int cy;

    @Override
    // Retrives player name from intent, sets the reset button and message
    // view to their respecitive views, sets the message view text, adds
    // the board buttons to an array
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetBtn = findViewById(R.id.reset);
        messageView = findViewById(R.id.gameOn);
        Intent intent = getIntent();
        name = intent.getStringExtra("playerName");
        messageView.setText("Game on " + name + "! Take your turn to start!");
        buttons[0] = findViewById(R.id.button00);
        buttons[1] = findViewById(R.id.button01);
        buttons[2] = findViewById(R.id.button02);
        buttons[3] = findViewById(R.id.button10);
        buttons[4] = findViewById(R.id.button11);
        buttons[5] = findViewById(R.id.button12);
        buttons[6] = findViewById(R.id.button20);
        buttons[7] = findViewById(R.id.button21);
        buttons[8] = findViewById(R.id.button22);
    }

    //onClick method for the reset button
    public void newGame(View view) {
        board.clearBoard();
        currentState = ITicTacToe.PLAYING;
        messageView.setText("Challenge accepted " + name + "!");
        for (Button b : buttons) {
            b.setText("");

            //Resets buttons to their default background
            b.setBackgroundResource(android.R.drawable.btn_default);
        }

        //Toggles reset button to the player cannot use it when a game is in progress
        resetBtn.setClickable(false);
        resetBtn.setVisibility(View.INVISIBLE);

    }

    //Code to handle the player move
    public void playerMove(View view) {

        //Player should not be able to make a move if the game is over
        if (currentState == ITicTacToe.PLAYING) {
            int position = 9;

            // Associates the board buttons to a position on the logic board in TicTacToe, sets the temp playerBtn
            // to the button selected
            switch (view.getId()) {
                case R.id.button00:
                    position = 0;
                    playerBtn = (Button) view;
                    break;
                case R.id.button01:
                    position = 1;
                    playerBtn = (Button) view;
                    break;
                case R.id.button02:
                    position = 2;
                    playerBtn = (Button) view;
                    break;
                case R.id.button10:
                    position = 3;
                    playerBtn = (Button) view;
                    break;
                case R.id.button11:
                    position = 4;
                    playerBtn = (Button) view;
                    break;
                case R.id.button12:
                    position = 5;
                    playerBtn = (Button) view;
                    break;
                case R.id.button20:
                    position = 6;
                    playerBtn = (Button) view;
                    break;
                case R.id.button21:
                    position = 7;
                    playerBtn = (Button) view;
                    break;
                case R.id.button22:
                    position = 8;
                    playerBtn = (Button) view;
                    break;
            }

            //send the move to lgoic board in TicTacToe and handle displaying the move
            board.setMove(0, position);

            //If the move was valid, update the button to refelct the player claimed it
            if (board.getValidPlayerMove()) {
                playerBtn.setText("X");
                playerBtn.setBackgroundColor(Color.RED);
                playerBtn.setTextColor(Color.WHITE);

            //If the move was not valid, notify the winner so they can select a new spot
            } else {
                Toast.makeText(this, "You made an invalid move, try again", Toast.LENGTH_LONG).show();
            }

            //Check to see if the player made a winning move
            winner();
        }

        //If no one has won the game yet and the player's previous move was valid
        if (currentState == ITicTacToe.PLAYING && board.getValidPlayerMove()) {

            //Let the player know the computer took its turn
            Toast.makeText(this, "The computer took its turn", Toast.LENGTH_SHORT).show();

            //Have TicTacToe select a user move and add it to the logic board
            board.getComputerMove();

            //If the computer made a valid move, update the button to reflect the computer claimed it
            if (board.getValidComputerMove()) {

                //Associate a location in the logc board with the corresponding button in the player's view
                cx = board.getCx();
                cy = board.getCy();
                compBtn = findViewById(getResources().getIdentifier("button" + cx + cy, "id", getPackageName()));
                compBtn.setText("O");
                compBtn.setBackgroundColor(Color.BLUE);
                compBtn.setTextColor(Color.WHITE);
            }

            //Check to see if the computer made a winning move
            winner();
        }

    }

    //Checks to see if there is a winner, and if so set the message on the top of the screen to refelct that
    public void winner() {

        //Get the current state from the logic board
        currentState = board.checkForWinner();

        //If the game has been finished
        if (currentState != ITicTacToe.PLAYING) {

            //Allow the player to see and use the reset button
            resetBtn.setVisibility(View.VISIBLE);
            resetBtn.setClickable(true);

            //If the player has won, display so in the message view at the top of the screen
            if (currentState == ITicTacToe.CROSS_WON) {
                messageView.setText("YOU WON, press the 'New Game' button to play again!");

            //If the computer has won, display so in the message view at the top of the screen
            } else if (currentState == ITicTacToe.NOUGHT_WON) {
                messageView.setText("You lost :(, press the 'New Game' button to play again!");

            //If no one has won, display so in the message view at the top of the screen
            } else if (currentState == ITicTacToe.TIE) {
                messageView.setText("Its a tie! Press the 'New Game' button to play again!");
            }
        } else {
            messageView.setText("You're up " + name);
        }
    }
}

