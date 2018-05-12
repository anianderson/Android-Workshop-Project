package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpecialFunctionPage extends AppCompatActivity {

    Button b, q, mmp;
    static int questionLevel, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_function_page);

        questionLevel = 1;
        score = 0;

        b = (Button) findViewById(R.id.specialfunctionpagebackbutton);
        q = (Button) findViewById(R.id.specialfunctionpagequizbutton);
        mmp = (Button) findViewById(R.id.specialfunctionpagemagicalmusicplayerbutton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpecialFunctionPage.this, HomePage.class));
                finish();
            }
        });

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpecialFunctionPage.this, QuizPage.class));
            }
        });

        mmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpecialFunctionPage.this, MagicalMusicPlayerPage.class));
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(SpecialFunctionPage.this, SpecialFunctionPage.class));
    }
}
