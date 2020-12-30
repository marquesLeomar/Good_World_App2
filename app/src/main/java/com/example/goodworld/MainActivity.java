package com.example.goodworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btntarefa1;
    private Button voltar;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntarefa1 = findViewById(R.id.btntarefa1);
        images =new int[]{R.drawable.botao2,R.drawable.botao};
        voltar = findViewById(R.id.btnsair3);
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

        Intent intent = new Intent(getApplicationContext(),Tarefas.class);
        startActivity(intent);

    }

    public void metodo1()  {
        // Thread.sleep(1500);
        btntarefa1.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo2()  {
        // Thread.sleep(1500);
        btntarefa1.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
    }

    public void metodo3()  {
        // Thread.sleep(1500);
        voltar.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo4()  {
        // Thread.sleep(1500);
        voltar.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
    }



    public void btnvoltar(View view)
    {
        voltar();
    }

    private void voltar()
    {

        metodo4();
        Handler handler = new Handler();
        long delay = 300;

        handler.postDelayed(new Runnable() {
            public void run() {
                // código a ser executado após o tempo de delay
                metodo3();
            }
        }, delay);

        Intent intent = new Intent(getApplicationContext(),Lema.class);
        startActivity(intent);
    }

}