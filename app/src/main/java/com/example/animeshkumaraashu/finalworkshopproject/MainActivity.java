package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView e;
    ImageView i;
    SQLiteDatabase d;
    //SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d = openOrCreateDatabase("finalproject", MODE_PRIVATE, null);

        //sp = getSharedPreferences("fpfile", MODE_PRIVATE);

        e = (TextView) findViewById(R.id.textView);
        i = (ImageView) findViewById(R.id.imageView2);

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableInDatabase();
                startActivity(new Intent(MainActivity.this, LoginPage.class));
                finish();
            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableInDatabase();
                //createUserFile();
                startActivity(new Intent(MainActivity.this, LoginPage.class));
                finish();
            }
        });
    }

    private void createTableInDatabase() {
        d.execSQL("create table if not exists user (name varchar, password varchar, email varchar, city varchar, phone varchar);");
        d.execSQL("create table if not exists quiz (qno int, question varchar, a1 varchar, a2 varchar, a3 varchar, a4 varchar," +
                "correctanswer int);");
        /*d.execSQL("create table if not exists loginstatus (login boolean not null, name varchar);");*/
        if (quizIsEmpty()) {
            d.execSQL("insert into quiz values (1, 'What is the capital of India?', 'New Delhi', 'Bangalore', 'Kolkata', 'Mumbai', 1);");
            d.execSQL("insert into quiz values (2, 'How many planets are in our solar system?', '9', '5', '8', '11', 3);");
            d.execSQL("insert into quiz values (3, 'Who is Sachin Tendulkar?', 'Actor', 'Scientist', 'Bussinessman', 'Cricketer', 4);");
            d.execSQL("insert into quiz values (4, 'Which of the following is not a browser?', 'Google Chrome', 'Facebook', 'Opera', 'Mozilla Firefox', 2);");
            d.execSQL("insert into quiz values (5, 'How many continents are there in the world?', '5', '6', '7', '8', 3);");
        }
    }

    private boolean quizIsEmpty() {
        return (d.rawQuery("select qno from quiz", null).getCount() <= 0);
    }

    /*private void createUserFile(){
        SharedPreferences.Editor spe = sp.edit();
        spe.putString("username", "");
        spe.commit();
    }*/
}
