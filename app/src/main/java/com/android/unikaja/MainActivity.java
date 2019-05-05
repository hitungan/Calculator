package com.android.unikaja;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1;
    private EditText num2;
    private RadioButton tbh;
    private RadioButton krng;
    private RadioButton kl;
    private RadioButton bg;
    private TextView r;
    private Button clt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.first_number);
        num2 = findViewById(R.id.second_number);
        tbh = findViewById(R.id.radioButton);
        krng = findViewById(R.id.radioButton2);
        kl = findViewById(R.id.radioButton3);
        bg = findViewById(R.id.radioButton4);
        r = findViewById(R.id.hasil);
        clt = findViewById(R.id.button);

        tbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                krng.setChecked(false);
                bg.setChecked(false);
                kl.setChecked(false);
            }
        });

        krng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bg.setChecked(false);
                tbh.setChecked(false);
                kl.setChecked(false);
            }
        });

        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                krng.setChecked(false);
                tbh.setChecked(false);
                bg.setChecked(false);
            }
        });

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                krng.setChecked(false);
                tbh.setChecked(false);
                kl.setChecked(false);
            }
        });

        clt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=0, b=0;
                int hasil = 0;
                try {
                    a = Integer.parseInt(num1.getText().toString());
                    b = Integer.parseInt(num2.getText().toString());
                } catch (Exception e) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertBuilder.setTitle("Masukin angka dulu");
                    alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertBuilder.create().show();
                    return;
                }

                if (tbh.isChecked()) {
                    hasil = a + b;
                } else if (krng.isChecked()) {
                    hasil = a-b;
                } else if (kl.isChecked()){
                    hasil = a*b;
                } else if (bg.isChecked()){
                    if (b == 0) {
                        r.setText("Tak Terhingga");
                        return;
                    }
                    hasil = a/b;
                } else {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertBuilder.setTitle("Pilih Dulu");
                    alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertBuilder.create().show();
                    return;
                }

                r.setText(String.valueOf(hasil));
            }
        });
    }
}
