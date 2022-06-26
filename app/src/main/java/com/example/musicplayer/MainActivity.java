package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button musicplay = (Button) findViewById(R.id.button);
        musicplay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               openMusicPlayer();
            }


        });
    }


    void openMusicPlayer(){
        Intent intent =
                new Intent(this,MusicPlayer.class);
        startActivity(intent);
    }
}