package com.example.animeshkumaraashu.finalworkshopproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorPage extends AppCompatActivity {

    Button b, a, s, m, d, reset;
    EditText n1, n2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_page);

        b = (Button) findViewById(R.id.calculatorpagebackbutton);
        a = (Button) findViewById(R.id.calculatorpageaddbutton);
        s = (Button) findViewById(R.id.calculatorpagesubtractbutton);
        m = (Button) findViewById(R.id.calculatorpagemultiplybutton);
        d = (Button) findViewById(R.id.calculatorpagedividebutton);
        reset = (Button) findViewById(R.id.calculatorpageresetbutton);

        n1 = (EditText) findViewById(R.id.calculatorpagenumber1edittext);
        n2 = (EditText) findViewById(R.id.calculatorpagenumber2edittext);

        result = (TextView) findViewById(R.id.calculatorpageresulttextview);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculatorPage.this, HomePage.class));
                finish();
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fieldIsEmpty()) {
                    result.setText("Result : " + ((Double.parseDouble(n1.getText().toString().trim()))
                            + (Double.parseDouble(n2.getText().toString().trim()))));
                } else {
                    Toast.makeText(CalculatorPage.this, "Please fill the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fieldIsEmpty()) {
                    result.setText("Result : " + ((Double.parseDouble(n1.getText().toString().trim()))
                            - (Double.parseDouble(n2.getText().toString().trim()))));
                } else {
                    Toast.makeText(CalculatorPage.this, "Please fill the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fieldIsEmpty()) {
                    result.setText("Result : " + ((Double.parseDouble(n1.getText().toString().trim()))
                            * (Double.parseDouble(n2.getText().toString().trim()))));
                } else {
                    Toast.makeText(CalculatorPage.this, "Please fill the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fieldIsEmpty()) {
                    result.setText("Result : " + ((Double.parseDouble(n1.getText().toString().trim()))
                            / (Double.parseDouble(n2.getText().toString().trim()))));
                } else {
                    Toast.makeText(CalculatorPage.this, "Please fill the numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1.setText("");
                n2.setText("");
                result.setText("RESULT");
                n1.requestFocus();
            }
        });
    }

    private boolean fieldIsEmpty() {
        return ((n1.getText().toString().trim().isEmpty()) || (n2.getText().toString().trim().isEmpty()));
    }
}
