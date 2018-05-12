package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MediaPlayerPage extends AppCompatActivity {

    Button b, play, pause;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_page);

        b = (Button) findViewById(R.id.mediaplayerpagebackbutton);
        play = (Button) findViewById(R.id.mediaplayerpageplaybutton);
        pause = (Button) findViewById(R.id.mediaplayerpagepausebutton);
        mp = MediaPlayer.create(this, R.raw.a);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MediaPlayerPage.this, HomePage.class));
                finish();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
    }

    @Override
    protected void onPause() {
        mp.stop();
        super.onPause();
    }
}
