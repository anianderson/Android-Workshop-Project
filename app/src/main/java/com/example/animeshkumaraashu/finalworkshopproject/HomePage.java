package com.example.animeshkumaraashu.finalworkshopproject;

//import android.content.DialogInterface;
import android.content.Intent;
//import android.content.SharedPreferences;
//import android.database.sqlite.SQLiteDatabase;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button b, m, cam, cal, sf;//, l;
    //AlertDialog.Builder builder, builder1;
    //SQLiteDatabase d;
    //SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //d = openOrCreateDatabase("finalproject", MODE_PRIVATE, null);

        b = (Button) findViewById(R.id.homepagebackbutton);
        m = (Button) findViewById(R.id.homepagemediaplayerbutton);
        cam = (Button) findViewById(R.id.homepagecamerabutton);
        cal = (Button) findViewById(R.id.homepagecalculatorbutton);
        sf = (Button) findViewById(R.id.homepagespecialfunctionbutton);
        //l = (Button) findViewById(R.id.homepagelogoutbutton);

        //sp = getSharedPreferences("finalprojectfile", MODE_PRIVATE);

        /*builder = new AlertDialog.Builder(this);

        builder.setTitle("First Logout");
        builder.setMessage("Do you want to quit without logout?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(HomePage.this, LoginPage.class));
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

        builder1 = new AlertDialog.Builder(this);

        builder1.setTitle("Are you sure");
        builder1.setMessage("Do you really want to logout?");

        builder1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                /*SharedPreferences.Editor spe = sp.edit();
                spe.putString("username", "~!@#$%^&*()_+=-0987654321`");
                spe.commit();*/
                /*d.execSQL("update loginstatus set login = 'false'");
                startActivity(new Intent(HomePage.this, LoginPage.class));
                finish();
                dialogInterface.dismiss();
            }
        });

        builder1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });*/

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, LoginPage.class));
                finish();
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, MediaPlayerPage.class));
                finish();
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, CameraPage.class));
                finish();
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, CalculatorPage.class));
                finish();
            }
        });

        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, SpecialFunctionPage.class));
                finish();
            }
        });

        /*l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, LoginPage.class));
                finish();
            }
        });*/
    }
}
