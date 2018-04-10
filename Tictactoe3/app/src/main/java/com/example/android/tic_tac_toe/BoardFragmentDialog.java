
/**
import android.app.Dialog;/
//public class BoardFragmentDialog {
//}
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
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

/*
*   This class extends the DialogFragment
*   It is used to set a layout file to the select Board type Dialog
*/
public class BoardFragmentDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstances) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //  Get Layout Inflator from current Activity
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //  Inflate and set the dialog's layout
        builder.setView(inflater.inflate(R.layout.board_type_dialog, null)) // Set parent view to null

                //  Add Dialog buttons
                .setPositiveButton(R.string.three, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getActivity(), ComputerActivity.class);
                        i.putExtra("computerPlayer", 0);
                        i.putExtra("humanPlayer", 0);
                        startActivity(i);
                        getActivity().finish();
                    }
                })
                .setNegativeButton(R.string.five, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getActivity(), ComputerFiveActivity.class);
                        i.putExtra("computerPlayer", 0);
                        i.putExtra("humanPlayer", 0);
                        startActivity(i);
                        getActivity().finish();
                    }
                });
        return builder.create();
    }
}