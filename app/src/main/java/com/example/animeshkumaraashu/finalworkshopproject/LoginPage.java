package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
/*import android.content.SharedPreferences;
import android.database.Cursor;*/
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button s, l;
    EditText u, p;
    SQLiteDatabase d;
    //SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        d = openOrCreateDatabase("finalproject", MODE_PRIVATE, null);

        s = (Button) findViewById(R.id.loginpagesignupbutton);
        l = (Button) findViewById(R.id.loginpageloginbutton);

        u = (EditText) findViewById(R.id.loginpageusernameedittext);
        p = (EditText) findViewById(R.id.loginpagepasswordedittext);

        /*sp = getSharedPreferences("finalprojectfile", MODE_PRIVATE);

        if (!((sp.getString("username", null).equals("~!@#$%^&*()_+=-0987654321`")) || (sp.getString("username", null).equals(null)))) {
            Toast.makeText(LoginPage.this, "WELCOME " + sp.getString("username", null).toUpperCase(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(LoginPage.this, HomePage.class));
            finish();
        }*/

        /*if (loggedIn()) {
            Toast.makeText(LoginPage.this, "WELCOME " + userLogged(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(LoginPage.this, HomePage.class));
            finish();
        }*/

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, SignUpPage.class));
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validUser(u.getText().toString().trim(), p.getText().toString().trim())) {
                    /*SharedPreferences.Editor spe = sp.edit();
                    spe.putString("username", u.getText().toString().trim());
                    spe.commit();*/
                    //loginDone(u.getText().toString().trim());
                    Toast.makeText(LoginPage.this, "WELCOME " + u.getText().toString().trim().toUpperCase(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginPage.this, HomePage.class));
                    finish();
                } else {
                    Toast.makeText(LoginPage.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validUser(String username, String password) {
        return (d.rawQuery("select name from user where(name = '" + username + "' and password = '"
                + password + "');", null).getCount() > 0);
    }

    /*private void loginDone(String username) {
        d.execSQL("delete from loginstatus");
        d.execSQL("insert into loginstatus values ('true', '" + username + "');");
    }

    private boolean loggedIn(){
        Cursor c = d.rawQuery("select login from loginstatus",null);
        c.moveToFirst();
        return(c.getString(0).equals("true"));
    }

    private String userLogged(){
        Cursor c = d.rawQuery("select name from loginstatus",null);
        c.moveToFirst();
        return(c.getString(0));
    }*/

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(LoginPage.this, LoginPage.class));
        finish();
    }
}
