package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizPage extends AppCompatActivity {

    SQLiteDatabase d;
    //int level;
    String selectedanswer, ca;
    RadioButton a1, a2, a3, a4;
    TextView q;
    Button b, s;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        d = openOrCreateDatabase("finalproject", MODE_PRIVATE, null);

        //level = HomePage.questionLevel;

        a1 = (RadioButton) findViewById(R.id.quizpageradiobutton1);
        a2 = (RadioButton) findViewById(R.id.quizpageradiobutton2);
        a3 = (RadioButton) findViewById(R.id.quizpageradiobutton3);
        a4 = (RadioButton) findViewById(R.id.quizpageradiobutton4);

        q = (TextView) findViewById(R.id.quizpagequestiontextview);

        b = (Button) findViewById(R.id.quizpagebackbutton);
        s = (Button) findViewById(R.id.quizpagesubmitbutton);

        ca = setQuestion();
        //setQuestion();

        if (Integer.parseInt(ca) > 1) {
            b.setEnabled(false);
        }

        builder = new AlertDialog.Builder(this);

        builder.setTitle("Are you sure");
        builder.setMessage("Do you want to submit this answer?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SpecialFunctionPage.questionLevel++;
                alterScore(ca, selectedanswer);
                if (SpecialFunctionPage.questionLevel > 5) {
                    startActivity(new Intent(QuizPage.this, ScorePage.class));
                } else {
                    startActivity(new Intent(QuizPage.this, QuizPage.class));
                }
                finish();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //+startActivity(new Intent(QuizPage.this, SpecialFunctionPage.class));
                finish();
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedanswer = "1";
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedanswer = "2";
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedanswer = "3";
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedanswer = "4";
            }
        });
    }

    private String setQuestion() {
        Cursor c = d.rawQuery("select question from quiz where qno = " + SpecialFunctionPage.questionLevel + ";", null);
        c.moveToFirst();
        q.setText(c.getString(0));
        c = d.rawQuery("select a1 from quiz where qno = " + SpecialFunctionPage.questionLevel + ";", null);
        c.moveToFirst();
        a1.setText(c.getString(0));
        c = d.rawQuery("select a2 from quiz where qno = " + SpecialFunctionPage.questionLevel + ";", null);
        c.moveToFirst();
        a2.setText(c.getString(0));
        c = d.rawQuery("select a3 from quiz where qno = " + SpecialFunctionPage.questionLevel + ";", null);
        c.moveToFirst();
        a3.setText(c.getString(0));
        c = d.rawQuery("select a4 from quiz where qno = " + SpecialFunctionPage.questionLevel + ";", null);
        c.moveToFirst();
        a4.setText(c.getString(0));
        c = d.rawQuery("select correctanswer from quiz where qno = " + SpecialFunctionPage.questionLevel + ";", null);
        c.moveToFirst();
        return (c.getString(0));
        /*a1.setText(c.getString(2));
        a1.setText(c.getString(3));
        a1.setText(c.getString(4));
        a1.setText(c.getString(5));
        return (c.getString(6));*/
    }

    private void alterScore(String x, String y) {
        if (x.equals(y)) {
            Toast.makeText(QuizPage.this, "Well Done... Right Answer", Toast.LENGTH_LONG).show();
            SpecialFunctionPage.score++;
        } else {
            Toast.makeText(QuizPage.this, "Oops... Wrong Answer", Toast.LENGTH_LONG).show();
            SpecialFunctionPage.score--;
        }
    }
}
