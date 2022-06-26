package com.example.musicplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {
     Button btnplay,btnnext,btnprev,btnff,btnfr;
     TextView textname,textsstart,textsstop;
     SeekBar seekmusic;

     String sname = new String("h");
     public static final String EXTRA_NAME = "song_name";
     static MediaPlayer mediaPlayer;
     String songname;
     int position;
     ArrayList<File> mySongs =new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);



        btnplay = (Button)findViewById(R.id.playbtn);
        btnnext =(Button) findViewById(R.id.btnnext);
        btnprev = (Button)findViewById(R.id.btnprev);
        btnff = (Button)findViewById(R.id.btnfastforward);
        btnfr = (Button)findViewById(R.id.btnfastrewind);
        textname = (TextView) findViewById(R.id.textsongname);
        textsstart = (TextView)findViewById(R.id.songtime1);
        textsstop = (TextView)findViewById(R.id.songtime2);
        seekmusic = (SeekBar) findViewById(R.id.seekbar);

        //29:30
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        Intent i = getIntent();
        Bundle bundle =i.getExtras();

        mySongs = bundle.getParcelable("songs");

        songname =i.getStringExtra("songname");
        position = i.getIntExtra("pos",0);

       // textname.setSelected(true);
        Uri uri;
        uri =Uri.parse(mySongs.get(position).toString());
        sname = mySongs.get(position).getName();
        textname.setText(sname);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),uri);
        mediaPlayer.start();

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    btnplay.setBackgroundResource(R.drawable.ic_play);
                    mediaPlayer.pause();

                }
                else{
                    btnplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                }
            }
        });


    }
}