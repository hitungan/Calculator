package com.android.unikaja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        clt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                int hasil = 0;
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());

                if (tbh.isChecked()) {
                    hasil = a + b;
                } else if (krng.isChecked()) {
                    hasil = a-b;
                } else if (kl.isChecked()){
                    hasil = a*b;
                } else if (bg.isChecked()){
                    hasil = a/b;
                }

                r.setText(String.valueOf(hasil));
            }
        });
    }
}
