package com.example.rizkianiktia.rizkianiktiasukoco_1202154339_studycase4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;



public class pencarigambar extends AppCompatActivity {
    //deklarasi variabel yang dibutuhkan
    ImageView gambar;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarigambar);

            // untuk memanggil variabel yang ada pada layout
        gambar =(ImageView)findViewById(R.id.gambar);
        url =(EditText) findViewById(R.id.url);

    }
    public void carigambar(View view) { //method apabila tombol ditekan

        Picasso.with(pencarigambar.this).load(url.getText().toString()) //untuk catch dan load image
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(gambar);
    }
}
