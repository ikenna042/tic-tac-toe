

/**
 *
 * Created by IKENNA on 4/10/2018.
 *
 */
/*
 * Copyright 2018 The Android Tic-tac-toe Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.tic_tac_toe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class HumanActivity extends AppCompatActivity {

    private String PlayerOne;
    private String PlayerTwo;
    private String playTurn = PlayerOne;
    private int PlayerTwoScore = 0;
    private int PlayerOneScore = 0;
    private String[] gameBoard = new String[9];
    private int[] winCombo = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);

        /*  Use AlertDialog to set preferred values for Players */
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Player One should choose X or O")
                .setPositiveButton(R.string.cross, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PlayerOne = "X";
                        PlayerTwo = "O";
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.nut, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PlayerOne = "O";
                        PlayerTwo = "X";
                        dialog.cancel();
                    }
                });
        builder.create().show();
    }

    /*   This method checks if a player has won and returns a boolean */
    public boolean winGame(String[] board, String player) {
        if (board[0] == player && board[1] == player && board[2] == player) {
            winCombo[0] = 0;
            winCombo[1] = 1;
            winCombo[2] = 2;
            return true;
        } else if (board[3] == player && board[4] == player && board[5] == player) {
            winCombo[0] = 3;
            winCombo[1] = 4;
            winCombo[2] = 5;
            return true;
        } else if (board[6] == player && board[7] == player && board[8] == player) {
            winCombo[0] = 6;
            winCombo[1] = 7;
            winCombo[2] = 8;
            return true;
        } else if (board[0] == player && board[3] == player && board[6] == player) {
            winCombo[0] = 0;
            winCombo[1] = 3;
            winCombo[2] = 6;
            return true;
        } else if (board[1] == player && board[4] == player && board[7] == player) {
            winCombo[0] = 1;
            winCombo[1] = 4;
            winCombo[2] = 7;
            return true;
        } else if (board[2] == player && board[5] == player && board[8] == player) {
            winCombo[0] = 2;
            winCombo[1] = 5;
            winCombo[2] = 8;
            return true;
        } else if (board[0] == player && board[4] == player && board[8] == player) {
            winCombo[0] = 0;
            winCombo[1] = 4;
            winCombo[2] = 8;
            return true;
        } else if (board[2] == player && board[4] == player && board[6] == player) {
            winCombo[0] = 2;
            winCombo[1] = 4;
            winCombo[2] = 6;
            return true;
        }
        return false;
    }

    /*  This method implements a Draw/Tie */
    public void drawGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Draw")
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(HumanActivity.this, MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setPositiveButton(R.string.play, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        int i = 0;
                        while (i < 9) {
                            writeBoard(i, "e");
                            i++;
                        }
                    }
                });
        builder.create().show();
    }

    /*
    *  This method when called upon
    *  Plays a position when it is empty
    *  checks for a win or draw
    *  returns a boolean
    */
    public boolean playPosition(int position) {
        if (gameBoard[position] != "X" && gameBoard[position] != "O") {
            gameBoard[position] = playTurn;
            writeBoard(position, playTurn);
            if (winGame(gameBoard, playTurn)) {
                gameOver();
                return true;
            }
            ArrayList<Integer> def = new ArrayList<>();
            def = emptyPositions();
            if (def.isEmpty()) {
                resetBoard();
                drawGame();
                return true;
            }
            if (playTurn == PlayerTwo) {
                playTurn = PlayerOne;
                TextView txtMessage = (TextView) findViewById(R.id.msg_hum_board_3);
                txtMessage.setText(R.string.playerOne);
            } else if (playTurn == PlayerOne) {
                playTurn = PlayerTwo;
                TextView txtMessage = (TextView) findViewById(R.id.msg_hum_board_3);
                txtMessage.setText(R.string.playerTwo);
            }
            return true;
        }
        Toast.makeText(HumanActivity.this, "Invalid Move", Toast.LENGTH_SHORT).show();
        return false;
    }

    /*   This method resets the board only   */
    public void resetBoard() {
        int i = 0;
        while (i < 9) {
            writeBoard(i, "e");
            gameBoard[i] = "e";
            i++;
        }
        playTurn = PlayerOne;
        TextView txtMessage = (TextView) findViewById(R.id.msg_hum_board_3);
        txtMessage.setText("" + R.string.playerOne);
    }

    /*   This method resets the game and board   */
    public void resetGame() {
        resetBoard();
        PlayerTwoScore = 0;
        PlayerOneScore = 0;
        TextView txtPlayerTwoScore = (TextView) findViewById(R.id.hum_board_3_player_two_score);
        txtPlayerTwoScore.setText("" + PlayerTwoScore);
        TextView txtPlayerOneScore = (TextView) findViewById(R.id.hum_board_3_player_one_score);
        txtPlayerOneScore.setText("" + PlayerOneScore);
    }

    /*   This method implements the Game Over   */
    public void gameOver() {
        String win = "Player One wins";
        if (playTurn == PlayerTwo) {
            win = "Player Two wins";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(win)
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(HumanActivity.this, MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setPositiveButton(R.string.play, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        int i = 0;
                        while (i < 9) {
                            writeBoard(i, "e");
                            i++;
                        }
                    }
                });
        builder.create().show();
        resetBoard();
        if (playTurn == PlayerTwo) {
            PlayerTwoScore++;
            TextView txtScore = (TextView) findViewById(R.id.hum_board_3_player_two_score);
            txtScore.setText("" + PlayerTwoScore);
        } else if (playTurn == PlayerOne) {
            PlayerOneScore++;
            TextView txtScore = (TextView) findViewById(R.id.hum_board_3_player_one_score);
            txtScore.setText("" + PlayerOneScore);
        }
    }

    /*   This method writes 'X' or 'O' on the UI board   */
    public void writeBoard(int position, String player) {
        switch (position) {
            case 0:
                TextView txt0 = (TextView) findViewById(R.id.hum_3_0);
                txt0.setText("" + player);
                break;
            case 1:
                TextView txt1 = (TextView) findViewById(R.id.hum_3_1);
                txt1.setText("" + player);
                break;
            case 2:
                TextView txt2 = (TextView) findViewById(R.id.hum_3_2);
                txt2.setText("" + player);
                break;
            case 3:
                TextView txt3 = (TextView) findViewById(R.id.hum_3_3);
                txt3.setText("" + player);
                break;
            case 4:
                TextView txt4 = (TextView) findViewById(R.id.hum_3_4);
                txt4.setText("" + player);
                break;
            case 5:
                TextView txt5 = (TextView) findViewById(R.id.hum_3_5);
                txt5.setText("" + player);
                break;
            case 6:
                TextView txt6 = (TextView) findViewById(R.id.hum_3_6);
                txt6.setText("" + player);
                break;
            case 7:
                TextView txt7 = (TextView) findViewById(R.id.hum_3_7);
                txt7.setText("" + player);
                break;
            case 8:
                TextView txt8 = (TextView) findViewById(R.id.hum_3_8);
                txt8.setText("" + player);
                break;
        }
    }

    /*   This method fetches the empty positions on the Game Board   */
    public ArrayList<Integer> emptyPositions() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Integer i = 0;
        while (i < 9) {
            if (gameBoard[i] != "X" && gameBoard[i] != "O") {
                result.add(i);
            }
            i += 1;
        }
        return result;
    }

    /*   This method plays position 0 on the game board when clicked from the UI   */
    public void play0(View v) {
        playPosition(0);
    }

    /*   This method plays position 1 on the game board when clicked from the UI   */
    public void play1(View v) {
        playPosition(1);
    }

    /*   This method plays position 2 on the game board when clicked from the UI   */
    public void play2(View v) {
        playPosition(2);
    }

    /*   This method plays position 3 on the game board when clicked from the UI   */
    public void play3(View v) {
        playPosition(3);
    }

    /*   This method plays position 4 on the game board when clicked from the UI   */
    public void play4(View v) {
        playPosition(4);
    }

    /*   This method plays position 5 on the game board when clicked from the UI   */
    public void play5(View v) {
        playPosition(5);
    }

    /*   This method plays position 6 on the game board when clicked from the UI   */
    public void play6(View v) {
        playPosition(6);
    }

    /*   This method plays position 7 on the game board when clicked from the UI   */
    public void play7(View v) {
        playPosition(7);
    }

    /*   This method plays position 8 on the game board when clicked from the UI   */
    public void play8(View v) {
        playPosition(8);
    }

    /*
    *    This method when called upon by the Reset Button
    *    Pops up an Alert Dialog to either
    *    Reset the board or the game
    */
    public void reset(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Do you want to Reset the Board or Game?")
                .setNegativeButton(R.string.game, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        resetGame();
                    }
                })
                .setPositiveButton(R.string.board, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        resetBoard();
                    }
                });
        builder.create().show();
    }
}
