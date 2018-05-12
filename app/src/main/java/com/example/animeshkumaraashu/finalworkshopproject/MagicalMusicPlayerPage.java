package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MagicalMusicPlayerPage extends AppCompatActivity implements SensorEventListener {

    Button b;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical_music_player_page);

        b = (Button) findViewById(R.id.magicalmusicplayerpagebackbutton);

        mp = MediaPlayer.create(this, R.raw.a);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MagicalMusicPlayerPage.this, SpecialFunctionPage.class));
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] > 5) {
            mp.start();
        } else {
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
    }
}
