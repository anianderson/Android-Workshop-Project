package com.example.animeshkumaraashu.finalworkshopproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    Button b, s;
    EditText u, p, cp, e, c, ph;
    SQLiteDatabase d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        d = openOrCreateDatabase("finalproject", MODE_PRIVATE, null);

        b = (Button) findViewById(R.id.signuppagebackbutton);
        s = (Button) findViewById(R.id.signuppagesignupbutton);

        u = (EditText) findViewById(R.id.signuppageusernameedittext);
        p = (EditText) findViewById(R.id.signuppagepasswordedittext);
        cp = (EditText) findViewById(R.id.signuppageconfirmpasswordedittext);
        e = (EditText) findViewById(R.id.signuppageemailedittext);
        c = (EditText) findViewById(R.id.signuppagecityedittext);
        ph = (EditText) findViewById(R.id.signuppagephoneedittext);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allFieldsAreFilled(u.getText().toString().trim(), p.getText().toString().trim(), cp.getText().toString().trim(),
                        e.getText().toString().trim(), c.getText().toString().trim(), ph.getText().toString().trim())) {
                    if (passwordMatched(p.getText().toString().trim(), cp.getText().toString().trim())) {
                        if (validPhone(ph.getText().toString().trim())) {
                            if (newUser(u.getText().toString().trim())) {
                                insertNewUser(u.getText().toString().trim(), p.getText().toString().trim(),
                                        e.getText().toString().trim(), c.getText().toString().trim(),
                                        ph.getText().toString().trim());
                                Toast.makeText(SignUpPage.this, "Thank you for registration", Toast.LENGTH_SHORT).show();
                                //sendMessageToNewUser("Thank you for registration!");
                                finish();
                            }else{
                                Toast.makeText(SignUpPage.this, "User already exists", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUpPage.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUpPage.this, "Password not matched", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignUpPage.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private boolean allFieldsAreFilled(String username, String password, String confirmpassword,
                                       String email, String city, String phone) {
        return (!((username.isEmpty()) || (password.isEmpty()) || (confirmpassword.isEmpty())
                || (email.isEmpty()) || (city.isEmpty()) || (phone.isEmpty())));
    }

    private boolean passwordMatched(String password, String confirmpassword) {
        return (password.equals(confirmpassword));
    }

    private boolean validPhone(String phone) {
        return ((phone.length() == 10) && ((phone.startsWith("8")) || (phone.startsWith("7")) || (phone.startsWith("9"))));
    }

    private boolean newUser(String username) {
        return (d.rawQuery("select name from user where name = '" + username + "'", null).getCount() <= 0);
    }

    private void insertNewUser(String username, String password, String email, String city, String phone) {
        d.execSQL("insert into user values ('" + username + "', '" + password + "', '" + email + "', '"
                + city + "', '" + phone + "')");
    }

    private void sendMessageToNewUser(String msg) {
    }
}
