package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScorePage extends AppCompatActivity {

    TextView s;
    Button b, f, t, n;
    WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        s = (TextView) findViewById(R.id.scorepagescoretextview);

        b = (Button) findViewById(R.id.scorepagebackbutton);
        f = (Button) findViewById(R.id.scorepagefacebookbutton);
        t = (Button) findViewById(R.id.scorepagetwitterbutton);
        n = (Button) findViewById(R.id.scorepagenetcampbutton);
        //h = (Button) findViewById(R.id.scorepagehomebutton);

        w = (WebView) findViewById(R.id.webView);

        s.setText("Your Score is : " + SpecialFunctionPage.score);
        Toast.makeText(ScorePage.this, "Thank you for playing", Toast.LENGTH_LONG).show();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(ScorePage.this, SpecialFunctionPage.class));
                finish();
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w.loadUrl("https://www.facebook.com");
            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w.loadUrl("https://www.twitter.com");
            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w.loadUrl("https://www.netcamp.in");
            }
        });
    }
}
