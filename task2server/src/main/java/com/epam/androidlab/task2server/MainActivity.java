package com.epam.androidlab.task2server;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
//import com.epam.androidlab.task2client.*;

import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(com.epam.androidlab.task2server.MainActivity.this,
                        "com.epam.androidlab.task2client.ACTIVITY")
                        == PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(com.epam.androidlab.task2server.MainActivity.this,
                            new String[]{"com.epam.androidlab.task2client.ACTIVITY"},
                            PERMISSION_REQUEST);
                }
            }
        });

    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.epam.androidlab.task2client",
                            "com.epam.androidlab.task2client.MainActivity"));
                    startActivity(intent);
                }
                return;
            }
        }
    }
}


