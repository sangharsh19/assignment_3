package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent intent = new Intent(this,MusicPlayer.class);
        startActivity(intent);
    }
}