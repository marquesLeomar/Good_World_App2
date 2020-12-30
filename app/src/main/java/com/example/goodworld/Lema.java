package com.example.goodworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class Lema extends AppCompatActivity {

 private Button btnSair;
    private Button btnLema;
 int[] images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lema);
        btnSair = findViewById(R.id.btnsair);
        images =new int[]{R.drawable.botao2,R.drawable.botao};
        btnLema = findViewById(R.id.btnLema);





    }



    public void sairPrograma (View view)  {
        Toast.makeText(getBaseContext(), "See you later!",Toast.LENGTH_LONG).show();

        //btnSair.setBackground(null);
       // Intent intent = new Intent (this, RippleActivity.class);

            btnSair.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));

        Handler handler = new Handler();
        long delay = 300;

        handler.postDelayed(new Runnable() {
            public void run() {
                // código a ser executado após o tempo de delay
                metodo();
            }
        }, delay);

            finish();


    }


    public void metodo()  {
        // Thread.sleep(1500);
        btnSair.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }



    public void metodo1()  {
        // Thread.sleep(1500);
        btnLema.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo2()  {
        // Thread.sleep(1500);
        btnLema.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
    }


    public void btnporxima(View view)
    {
        proxima();
    }

    private void proxima()
    {

        metodo2();
        Handler handler = new Handler();
        long delay = 300;

        handler.postDelayed(new Runnable() {
            public void run() {
                // código a ser executado após o tempo de delay
                metodo1();
            }
        }, delay);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }




}

