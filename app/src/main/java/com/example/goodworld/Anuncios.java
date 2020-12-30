package com.example.goodworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Anuncios extends AppCompatActivity {

    private Button btnSair;
    private Button btnvoltar;
    int[] images;

    private AdView mAdView1;
    private AdView mAdView2;
    private AdView mAdView3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
        btnSair = findViewById(R.id.btnsair4);
        images =new int[]{R.drawable.botao2,R.drawable.botao};
        btnvoltar = findViewById(R.id.btnsair2);





        MobileAds.initialize(this, new OnInitializationCompleteListener() {




            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }





            /* */
        });

        AdView adView = new AdView(this);
        AdView adView2 = new AdView(this);
        AdView adView3 = new AdView(this);

        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-4389621952707823/3752030919");
        adView2.setAdSize(AdSize.BANNER);
        adView2.setAdUnitId("ca-app-pub-4389621952707823/9635198394");
        adView3.setAdSize(AdSize.BANNER);
        adView3.setAdUnitId("ca-app-pub-4389621952707823/5079933769");


        mAdView1 = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);

        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest1);
        mAdView3 = findViewById(R.id.adView3);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest2);



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
        btnvoltar.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[1]));
    }
    public void metodo2()  {
        // Thread.sleep(1500);
        btnvoltar.setBackground(ContextCompat.getDrawable(getApplicationContext(), images[0]));
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
}