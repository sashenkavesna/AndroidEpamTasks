package com.epam.androidlab.task2client;


import android.view.View;
import android.widget.EditText;

public class EditTextListener implements View.OnClickListener {
    EditText edit;
    EditTextListener(EditText edit){
        this.edit=edit;
    }
    @Override
    public void onClick(View v) {
        edit.setText(" ");
    }
}
