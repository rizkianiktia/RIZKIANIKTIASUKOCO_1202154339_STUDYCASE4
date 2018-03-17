package com.example.rizkianiktia.rizkianiktiasukoco_1202154339_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Halamanawal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanawal);
        setTitle("AsynTask");
    }

    public void listmahasiswa(View view) {
        //untuk berpindah ke aktivitas listmahasiswa//
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //method saat button ditekan
    public void image(View view) {
        //untuk berpindah ke aktivitas image//
        Intent intent = new Intent(this, pencarigambar.class);
        startActivity(intent);
    }
}