

/**
 *
 * package com.example.android.tic_tac_toe;
 *
 */

/*
 * Copyright 2018 The Android Open Source Project
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

public class ComputerFiveActivity extends AppCompatActivity {

    private String computerPlayer;
    private String humanPlayer;
    private String playTurn = humanPlayer;
    private int humanScore = 0;
    private int computerScore = 0;
    private String[] gameBoard = new String[25];
    private int[] winCombo = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_five);

        Intent i = getIntent();
        humanScore = i.getIntExtra("humanScore", 0);
        computerScore = i.getIntExtra("computerScore", 0);

        /*  Use AlertDialog to set preferred values for Players */
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Please select X or O")
                .setPositiveButton(R.string.cross, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        humanPlayer = "X";
                        computerPlayer = "O";
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.nut, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        humanPlayer = "O";
                        computerPlayer = "X";
                        dialog.cancel();
                    }
                });
        builder.create().show();

        TextView txtHumanScore = (TextView) findViewById(R.id.com_board_5_player_score);
        txtHumanScore.setText("" + humanScore);

        TextView txtComputerScore = (TextView) findViewById(R.id.com_board_5_computer_score);
        txtHumanScore.setText("" + computerScore);
    }

    /*   This method checks if a player has won and returns a boolean */
    public boolean winGame(String[] board, String player) {
        if (board[0] == player && board[1] == player && board[2] == player && board[3] == player && board[4] == player) {
            winCombo[0] = 0;
            winCombo[1] = 1;
            winCombo[2] = 2;
            winCombo[3] = 3;
            winCombo[4] = 4;
            return true;
        } else if (board[5] == player && board[6] == player && board[7] == player && board[8] == player && board[9] == player) {
            winCombo[0] = 5;
            winCombo[1] = 6;
            winCombo[2] = 7;
            winCombo[3] = 8;
            winCombo[4] = 9;
            return true;
        } else if (board[10] == player && board[11] == player && board[12] == player && board[13] == player && board[14] == player) {
            winCombo[0] = 10;
            winCombo[1] = 11;
            winCombo[2] = 12;
            winCombo[3] = 13;
            winCombo[4] = 14;
            return true;
        } else if (board[15] == player && board[16] == player && board[17] == player && board[18] == player && board[19] == player) {
            winCombo[0] = 15;
            winCombo[1] = 16;
            winCombo[2] = 17;
            winCombo[3] = 18;
            winCombo[4] = 19;
            return true;
        } else if (board[20] == player && board[21] == player && board[22] == player && board[23] == player && board[24] == player) {
            winCombo[0] = 20;
            winCombo[1] = 21;
            winCombo[2] = 22;
            winCombo[3] = 23;
            winCombo[4] = 24;
            return true;
        } else if (board[0] == player && board[5] == player && board[10] == player && board[15] == player && board[20] == player) {
            winCombo[0] = 0;
            winCombo[1] = 5;
            winCombo[2] = 10;
            winCombo[3] = 15;
            winCombo[4] = 20;
            return true;
        } else if (board[1] == player && board[6] == player && board[11] == player && board[16] == player && board[21] == player) {
            winCombo[0] = 1;
            winCombo[1] = 6;
            winCombo[2] = 11;
            winCombo[3] = 16;
            winCombo[4] = 21;
            return true;
        } else if (board[2] == player && board[7] == player && board[12] == player && board[17] == player && board[22] == player) {
            winCombo[0] = 2;
            winCombo[1] = 7;
            winCombo[2] = 12;
            winCombo[3] = 17;
            winCombo[4] = 22;
            return true;
        } else if (board[3] == player && board[8] == player && board[13] == player && board[18] == player && board[23] == player) {
            winCombo[0] = 3;
            winCombo[1] = 8;
            winCombo[2] = 13;
            winCombo[3] = 18;
            winCombo[4] = 23;
            return true;
        } else if (board[4] == player && board[9] == player && board[14] == player && board[19] == player && board[24] == player) {
            winCombo[0] = 4;
            winCombo[1] = 9;
            winCombo[2] = 14;
            winCombo[3] = 19;
            winCombo[4] = 24;
            return true;
        } else if (board[0] == player && board[6] == player && board[12] == player && board[18] == player && board[24] == player) {
            winCombo[0] = 0;
            winCombo[1] = 6;
            winCombo[2] = 12;
            winCombo[3] = 18;
            winCombo[4] = 24;
            return true;
        } else if (board[4] == player && board[8] == player && board[12] == player && board[16] == player && board[20] == player) {
            winCombo[0] = 4;
            winCombo[1] = 8;
            winCombo[2] = 12;
            winCombo[3] = 16;
            winCombo[4] = 20;
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
                        Intent i = new Intent(ComputerFiveActivity.this, MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setPositiveButton(R.string.play, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        int i = 0;
                        while (i < 25) {
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
            if (playTurn == humanPlayer) {
                playTurn = computerPlayer;
                TextView txtMessage = (TextView) findViewById(R.id.msg_com_board_5);
                txtMessage.setText(R.string.computer_turn);
                computerPlay();
            } else if (playTurn == computerPlayer) {
                playTurn = humanPlayer;
                TextView txtMessage = (TextView) findViewById(R.id.msg_com_board_5);
                txtMessage.setText(R.string.human_turn);
            }
            return true;
        }
        Toast.makeText(ComputerFiveActivity.this, "Invalid Move", Toast.LENGTH_SHORT).show();
        return false;
    }

    /*   This method resets the board only   */
    public void resetBoard() {
        int i = 0;
        while (i < 25) {
            writeBoard(i, "e");
            gameBoard[i] = "e";
            i++;
        }
        playTurn = humanPlayer;
        TextView txtMessage = (TextView) findViewById(R.id.msg_com_board_5);
        txtMessage.setText("" + R.string.human_turn);
    }

    /*   This method resets the game and board   */
    public void resetGame() {
        resetBoard();
        humanScore = 0;
        computerScore = 0;
        TextView txtHumanScore = (TextView) findViewById(R.id.com_board_5_player_score);
        txtHumanScore.setText("" + humanScore);
        TextView txtComputerScore = (TextView) findViewById(R.id.com_board_5_computer_score);
        txtComputerScore.setText("" + computerScore);
    }

    /*  This method implements computer play */
    public void computerPlay() {
        int position;
        ArrayList<Integer> list = emptyPositions();
        position = list.get((int) (Math.random() * list.size()));
        playPosition(position);
    }

    /*   This method implements the Game Over   */
    public void gameOver() {
        String win = "You Lose";
        if (playTurn == humanPlayer) {
            win = "You Win";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(win)
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(ComputerFiveActivity.this, MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setPositiveButton(R.string.play, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        int i = 0;
                        while (i < 25) {
                            writeBoard(i, "e");
                            i++;
                        }
                    }
                });
        builder.create().show();
        resetBoard();

        if (playTurn == humanPlayer) {
            humanScore++;
            TextView txtScore = (TextView) findViewById(R.id.com_board_5_player_score);
            txtScore.setText("" + humanScore);
        } else if (playTurn == computerPlayer) {
            computerScore++;
            TextView txtScore = (TextView) findViewById(R.id.com_board_5_computer_score);
            txtScore.setText("" + computerScore);
        }
    }

    /*   This method writes 'X' or 'O' on the UI board   */
    public void writeBoard(int position, String player) {
        switch (position) {
            case 0:
                TextView txt0 = (TextView) findViewById(R.id.com_5_0);
                txt0.setText("" + player);
                break;
            case 1:
                TextView txt1 = (TextView) findViewById(R.id.com_5_1);
                txt1.setText("" + player);
                break;
            case 2:
                TextView txt2 = (TextView) findViewById(R.id.com_5_2);
                txt2.setText("" + player);
                break;
            case 3:
                TextView txt3 = (TextView) findViewById(R.id.com_5_3);
                txt3.setText("" + player);
                break;
            case 4:
                TextView txt4 = (TextView) findViewById(R.id.com_5_4);
                txt4.setText("" + player);
                break;
            case 5:
                TextView txt5 = (TextView) findViewById(R.id.com_5_5);
                txt5.setText("" + player);
                break;
            case 6:
                TextView txt6 = (TextView) findViewById(R.id.com_5_6);
                txt6.setText("" + player);
                break;
            case 7:
                TextView txt7 = (TextView) findViewById(R.id.com_5_7);
                txt7.setText("" + player);
                break;
            case 8:
                TextView txt8 = (TextView) findViewById(R.id.com_5_8);
                txt8.setText("" + player);
                break;
            case 9:
                TextView txt9 = (TextView) findViewById(R.id.com_5_9);
                txt9.setText("" + player);
                break;
            case 10:
                TextView txt10 = (TextView) findViewById(R.id.com_5_10);
                txt10.setText("" + player);
                break;
            case 11:
                TextView txt11 = (TextView) findViewById(R.id.com_5_11);
                txt11.setText("" + player);
                break;
            case 12:
                TextView txt12 = (TextView) findViewById(R.id.com_5_12);
                txt12.setText("" + player);
                break;
            case 13:
                TextView txt13 = (TextView) findViewById(R.id.com_5_13);
                txt13.setText("" + player);
                break;
            case 14:
                TextView txt14 = (TextView) findViewById(R.id.com_5_14);
                txt14.setText("" + player);
                break;
            case 15:
                TextView txt15 = (TextView) findViewById(R.id.com_5_15);
                txt15.setText("" + player);
                break;
            case 16:
                TextView txt16 = (TextView) findViewById(R.id.com_5_16);
                txt16.setText("" + player);
                break;
            case 17:
                TextView txt17 = (TextView) findViewById(R.id.com_5_17);
                txt17.setText("" + player);
                break;
            case 18:
                TextView txt18 = (TextView) findViewById(R.id.com_5_18);
                txt18.setText("" + player);
                break;
            case 19:
                TextView txt19 = (TextView) findViewById(R.id.com_5_19);
                txt19.setText("" + player);
                break;
            case 20:
                TextView txt20 = (TextView) findViewById(R.id.com_5_20);
                txt20.setText("" + player);
                break;
            case 21:
                TextView txt21 = (TextView) findViewById(R.id.com_5_21);
                txt21.setText("" + player);
                break;
            case 22:
                TextView txt22 = (TextView) findViewById(R.id.com_5_22);
                txt22.setText("" + player);
                break;
            case 23:
                TextView txt23 = (TextView) findViewById(R.id.com_5_23);
                txt23.setText("" + player);
                break;
            case 24:
                TextView txt24 = (TextView) findViewById(R.id.com_5_24);
                txt24.setText("" + player);
                break;
        }
    }

    /*   This method fetches the empty positions on the Game Board   */
    public ArrayList<Integer> emptyPositions() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Integer i = 0;
        while (i < 25) {
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

    /*   This method plays position 9 on the game board when clicked from the UI   */
    public void play9(View v) {
        playPosition(9);
    }

    /*   This method plays position 10 on the game board when clicked from the UI   */
    public void play10(View v) {
        playPosition(10);
    }

    /*   This method plays position 11 on the game board when clicked from the UI   */
    public void play11(View v) {
        playPosition(11);
    }

    /*   This method plays position 12 on the game board when clicked from the UI   */
    public void play12(View v) {
        playPosition(12);
    }

    /*   This method plays position 13 on the game board when clicked from the UI   */
    public void play13(View v) {
        playPosition(13);
    }

    /*   This method plays position 14 on the game board when clicked from the UI   */
    public void play14(View v) {
        playPosition(14);
    }

    /*   This method plays position 15 on the game board when clicked from the UI   */
    public void play15(View v) {
        playPosition(15);
    }

    /*   This method plays position 16 on the game board when clicked from the UI   */
    public void play16(View v) {
        playPosition(16);
    }

    /*   This method plays position 17 on the game board when clicked from the UI   */
    public void play17(View v) {
        playPosition(17);
    }

    /*   This method plays position 18 on the game board when clicked from the UI   */
    public void play18(View v) {
        playPosition(18);
    }

    /*   This method plays position 19 on the game board when clicked from the UI   */
    public void play19(View v) {
        playPosition(19);
    }

    /*   This method plays position 20 on the game board when clicked from the UI   */
    public void play20(View v) {
        playPosition(20);
    }

    /*   This method plays position 21 on the game board when clicked from the UI   */
    public void play21(View v) {
        playPosition(21);
    }

    /*   This method plays position 22 on the game board when clicked from the UI   */
    public void play22(View v) {
        playPosition(22);
    }

    /*   This method plays position 23 on the game board when clicked from the UI   */
    public void play23(View v) {
        playPosition(23);
    }

    /*   This method plays position 24 on the game board when clicked from the UI   */
    public void play24(View v) {
        playPosition(24);
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

    /*  This method changes the board type but retains the game Score  */
    public void changeBoard(View v) {
        Intent intent = new Intent(ComputerFiveActivity.this, ComputerActivity.class);
        intent.putExtra("computerScore", computerScore);
        intent.putExtra("humanScore", humanScore);
        startActivity(intent);
        finish();
    }

}
