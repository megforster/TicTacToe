package edu.quinnipiac.ser210.tictactoe;

import android.app.Activity;

import java.io.Serializable;


public class TicTacToe extends Activity implements ITicTacToe, Serializable {

    // Instance variables
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private int[][] board = new int[ROWS][COLS]; // game board in 2D array
    public int playerSymbol = CROSS;
    public int computerSymbol = NOUGHT;

    //Used to indcate if the player/computer has made a valid move
    private boolean validPlayerMove, validComputerMove;

    //Used to select correct button ID in MainActivity
    private int cx, cy;


    //Constructor

    public TicTacToe() {
    }

    @Override
    //Reset 2D array that controls board logic
    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }

    }

    //return if the player made a valid game move
    public boolean getValidPlayerMove() {
        return validPlayerMove;
    }

    //return if the computer made a valid game move
    public boolean getValidComputerMove() {
        return validComputerMove;
    }

    //return the computer move's row number
    public int getCx() {
        return cx;
    }

    //return the computer move's column number
    public int getCy() {
        return cy;
    }


    @Override
    //Logic for validating and displaying the players move
    public void setMove(int player, int location) {
        validPlayerMove = true;

        // Links the button the player pressed to a spot on the logic board.
        // If the board spot is currently the associating goes through,
        // the board spot is set to the player's symbol, and validPlayerMove
        // is set to true. If the spot is already taken it sets the
        // validPlayerMove to false.

        switch (location) {
            case 0:
                if (board[0][0] == EMPTY) {
                    board[0][0] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 1:
                if (board[0][1] == EMPTY) {
                    board[0][1] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 2:
                if (board[0][2] == EMPTY) {
                    board[0][2] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 3:
                if (board[1][0] == EMPTY) {
                    board[1][0] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 4:
                if (board[1][1] == EMPTY) {
                    board[1][1] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 5:
                if (board[1][2] == EMPTY) {
                    board[1][2] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 6:
                if (board[2][0] == EMPTY) {
                    board[2][0] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 7:
                if (board[2][1] == EMPTY) {
                    board[2][1] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            case 8:
                if (board[2][2] == EMPTY) {
                    board[2][2] = playerSymbol;
                } else {
                    validPlayerMove = false;
                }
                break;
            default:
                validPlayerMove = false;
                break;
        }
    }

    @Override
    //Logic for validating and displaying the computer's move
    public int getComputerMove() {
// TODO Auto-generated method stub
        //defualt assignment for blocking computer move row and column
        cx = 3;
        cx = 3;

        //default assignment for random computer move row and column
        int move_a = 3;
        int move_b = 3;

        validComputerMove = false;

        //Block row
        //Row 1
        if (board[0][0] == playerSymbol && board[0][1] == playerSymbol && board[0][2] == EMPTY) {
            board[0][2] = computerSymbol;
            cx = 0;
            cy = 2;
            validComputerMove = true;
        } else if (board[0][2] == playerSymbol && board[0][1] == playerSymbol && board[0][0] == EMPTY) {
            board[0][0] = computerSymbol;
            cx = 0;
            cy = 0;
            validComputerMove = true;
        } else if (board[0][2] == playerSymbol && board[0][0] == playerSymbol && board[0][1] == EMPTY) {
            board[0][1] = computerSymbol;
            cx = 0;
            cy = 1;
            validComputerMove = true;
        }

        //Row 2
        else if (board[1][0] == playerSymbol && board[1][1] == playerSymbol && board[1][2] == EMPTY) {
            board[1][2] = computerSymbol;
            cx = 1;
            cy = 2;
            validComputerMove = true;
        } else if (board[1][2] == playerSymbol && board[1][1] == playerSymbol && board[1][0] == EMPTY) {
            board[1][0] = computerSymbol;
            cx = 1;
            cy = 0;
            validComputerMove = true;
        } else if (board[1][0] == playerSymbol && board[1][2] == playerSymbol && board[1][1] == EMPTY) {
            board[1][1] = computerSymbol;
            cx = 1;
            cy = 1;
            validComputerMove = true;
        }

        //Row 3
        else if (board[2][0] == playerSymbol && board[2][1] == playerSymbol && board[2][2] == EMPTY) {
            board[2][2] = computerSymbol;
            cx = 2;
            cy = 2;
            validComputerMove = true;
        } else if (board[2][2] == playerSymbol && board[2][1] == playerSymbol && board[2][0] == EMPTY) {
            board[2][0] = computerSymbol;
            cx = 2;
            cy = 0;
            validComputerMove = true;
        } else if (board[2][0] == playerSymbol && board[2][2] == playerSymbol && board[2][1] == EMPTY) {
            board[2][1] = computerSymbol;
            cx = 2;
            cy = 1;
            validComputerMove = true;
        }

        //Block column
        //Column 1
        else if (board[0][0] == playerSymbol && board[1][0] == playerSymbol && board[0][0] == EMPTY) {
            board[2][0] = computerSymbol;
            cx = 2;
            cy = 0;
            validComputerMove = true;
        } else if (board[2][0] == playerSymbol && board[1][0] == playerSymbol && board[0][0] == EMPTY) {
            board[0][0] = computerSymbol;
            cx = 0;
            cy = 0;
            validComputerMove = true;
        } else if (board[0][0] == playerSymbol && board[2][0] == playerSymbol && board[1][0] == EMPTY) {
            board[1][0] = computerSymbol;
            cx = 1;
            cy = 0;
            validComputerMove = true;
        }

        //Column 2
        else if (board[0][1] == playerSymbol && board[1][1] == playerSymbol && board[2][1] == EMPTY) {
            board[2][1] = computerSymbol;
            cx = 2;
            cy = 1;
            validComputerMove = true;
        } else if (board[2][1] == playerSymbol && board[1][1] == playerSymbol && board[0][1] == EMPTY) {
            board[0][1] = computerSymbol;
            cx = 0;
            cy = 1;
            validComputerMove = true;
        } else if (board[0][1] == playerSymbol && board[2][1] == playerSymbol && board[1][1] == EMPTY) {
            board[1][1] = computerSymbol;
            cx = 1;
            cy = 1;
            validComputerMove = true;
        }

        //Column 3
        else if (board[0][2] == playerSymbol && board[1][2] == playerSymbol && board[2][2] == EMPTY) {
            board[2][2] = computerSymbol;
            cx = 2;
            cy = 2;
            validComputerMove = true;
        } else if (board[2][2] == playerSymbol && board[1][2] == playerSymbol && board[0][2] == EMPTY) {
            board[0][2] = computerSymbol;
            cx = 0;
            cy = 2;
            validComputerMove = true;
        } else if (board[0][2] == playerSymbol && board[2][2] == playerSymbol && board[1][2] == EMPTY) {
            board[1][2] = computerSymbol;
            cx = 1;
            cy = 2;
            validComputerMove = true;
        }

        // Diagonal from left to right
        else if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == EMPTY) {
            board[2][2] = computerSymbol;
            cx = 2;
            cy = 2;
            validComputerMove = true;
        } else if (board[2][2] == playerSymbol && board[1][1] == playerSymbol && board[0][0] == EMPTY) {
            board[0][0] = computerSymbol;
            cx = 0;
            cy = 0;
            validComputerMove = true;
        } else if (board[0][0] == playerSymbol && board[2][2] == playerSymbol && board[1][1] == EMPTY) {
            board[1][1] = computerSymbol;
            cx = 1;
            cy = 1;
            validComputerMove = true;
        }

        //Diagonal from right to left
        else if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == EMPTY) {
            board[2][0] = computerSymbol;
            cx = 2;
            cy = 0;
            validComputerMove = true;
        } else if (board[2][0] == playerSymbol && board[1][1] == playerSymbol && board[0][2] == EMPTY) {
            board[0][2] = computerSymbol;
            cx = 0;
            cy = 2;
            validComputerMove = true;
        } else if (board[2][0] == playerSymbol && board[0][2] == playerSymbol && board[1][1] == EMPTY) {
            board[1][1] = computerSymbol;
            cx = 1;
            cy = 1;
            validComputerMove = true;
        }

        //When the computer has nothing to block, make a random move in an open space
        else {
            while (!validComputerMove) {
                move_a = (int) (Math.random() * 3);
                move_b = (int) (Math.random() * 3);
                if (board[move_a][move_b] == EMPTY) {
                    board[move_a][move_b] = computerSymbol;
                    cx = move_a;
                    cy = move_b;
                    validComputerMove = true;
                }
            }

        }
        return 0;
    }


    @Override
    //Handles checking the board to see if either player has claimed three board sports in a row/column/diagonal
    public int checkForWinner() {
        // TODO Auto-generated method stub

        //Returns the game state
        int winner = PLAYING;

        //Row 1
        if (board[0][0] != EMPTY && board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == board[0][2]) {
            if (board[0][0] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[0][0] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Row 2
        if (board[1][0] != EMPTY && board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][1] == board[1][2]) {
            if (board[1][0] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[1][0] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Row 3
        if (board[2][0] != EMPTY && board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][1] == board[2][2]) {
            if (board[2][0] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[2][0] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Column 1
        if (board[0][0] != EMPTY && board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[1][0] == board[2][0]) {
            if (board[0][0] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[0][0] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Column 2
        if (board[0][1] != EMPTY && board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[1][1] == board[2][1]) {
            if (board[0][1] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[0][1] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Column 3
        if (board[0][2] != EMPTY && board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[1][2] == board[2][2]) {
            if (board[0][2] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[0][2] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Diagonal from left to right
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] == board[2][2]) {
            if (board[0][0] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[0][0] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Diagonal from right to left
        if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] == board[2][0]) {
            if (board[0][2] == NOUGHT) {
                winner = NOUGHT_WON;
            } else if (board[0][2] == CROSS) {
                winner = CROSS_WON;
            }
        }

        //Tie
        int full = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != EMPTY) {
                    full++;
                }
            }
        }

        //Makes sure to not override the player or computer winning by claiming the last spot on the board
        if (full == 9) {
            if (winner == CROSS_WON) {

            } else if (winner == NOUGHT_WON) {

            } else if (winner == PLAYING) {
                winner = TIE;
            }
        }

        return winner;
    }


}

