package com.example.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageButton basla,durdur,sifirla;
    Runnable runnable;
    Handler handler;
    int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.text);
        sifirla = findViewById(R.id.sifirla);
        durdur = findViewById(R.id.durdur);
        basla =  findViewById(R.id.basla);




        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basla.setEnabled(false); //butona bir sefer basılmasını sağlar
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        x++;
                        textView.setText(Integer.toString(x));
                        handler.postDelayed(runnable,1000);
                    }
                };
                handler.post(runnable);


            }
        });


        durdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                basla.setEnabled(true);
            }
        });


        sifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                basla.setEnabled(true);
                x=0;
                textView.setText(Integer.toString(x));
            }
        });









    }
}