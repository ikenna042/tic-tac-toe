

/**
 *
 * Created by IKENNA on 4/10/2018.
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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*  This class handles the Menu Launcher Activity   */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /*  This method shows the Board Alert Dialog to start One Player Mode   */
    public void computer(View v) {
        BoardFragmentDialog dialog = new BoardFragmentDialog();
        dialog.show(getFragmentManager(), "Board");
    }


    /*  This method starts up the two player Intent   */
    public void human(View v) {
        Intent i = new Intent(this, HumanActivity.class);
        startActivity(i);
        finish();
    }


    public void quit (View view) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }
}

