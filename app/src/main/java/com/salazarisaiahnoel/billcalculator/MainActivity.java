package com.salazarisaiahnoel.billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    TextView t1, t2;
    CheckBox c;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.billamount);
        e2 = findViewById(R.id.percent);
        e3 = findViewById(R.id.amount);
        t1 = findViewById(R.id.result1);
        t2 = findViewById(R.id.result2);
        c = findViewById(R.id.cb);
        l = findViewById(R.id.split_layout);

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double rate = Integer.parseInt(e1.getText().toString()) * ((double) Integer.parseInt(e2.getText().toString()) / 100);
                    t1.setText(String.valueOf(rate));
                } catch (Exception ignored){
                }
                try {
                    double rate = (double) Integer.parseInt(e1.getText().toString()) / Integer.parseInt(e3.getText().toString());
                    t2.setText(String.valueOf(rate));
                } catch (Exception ignored){
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double rate = Integer.parseInt(e1.getText().toString()) * ((double) Integer.parseInt(e2.getText().toString()) / 100);
                    t1.setText(String.valueOf(rate));
                } catch (Exception ignored){
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        e3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double rate = (double) Integer.parseInt(e1.getText().toString()) / Integer.parseInt(e3.getText().toString());
                    t2.setText(String.valueOf(rate));
                } catch (Exception ignored){
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.isChecked()){
                    l.setVisibility(View.VISIBLE);
                } else {
                    l.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            if (c.isChecked()){
                l.setVisibility(View.VISIBLE);
            } else {
                l.setVisibility(View.GONE);
            }
        } catch (Exception ignored){
        }
    }
}