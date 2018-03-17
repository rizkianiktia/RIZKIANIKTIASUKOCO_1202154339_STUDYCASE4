package com.example.rizkianiktia.rizkianiktiasukoco_1202154339_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listMahasiswa; //deklarasi variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("AsyncTask"); //set title untuk tampilan
        listMahasiswa = (ListView) findViewById(R.id.listMahasiswa);

    }
//method saat button mulai ditekan
    public void mulai(View view) {
        new getData(listMahasiswa).execute(); //proses asynctak dimulai
    }
    //subclass assynctask
    class getData extends AsyncTask<String, Integer, String> {
        ListView listMhsw;
        ArrayAdapter adapter;
        ArrayList<String> listNama;
        ProgressDialog dialog;

        //konstruktor saat asynctask diinisialisasi
        public getData(ListView listMhswhsw) {
            this.listMhsw = listMhswhsw;
            dialog = new ProgressDialog(MainActivity.this);
            listNama = new ArrayList<>();

        }

        //method sebelum proses asynctask dimulai
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setTitle("Loading Data"); //menampilkan proses dialog
            dialog.setIndeterminate(true);
            dialog.setProgress(0);
            dialog.setMax(100);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });

            dialog.show();
        }
        //method saat proses asynctask dijalankan
        @Override
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listNama); //membuat adapter
            String[] mhs = getResources().getStringArray(R.array.namaMhsw);  //menyimpan array pada sebuah variabel
            for (int a = 0; a < mhs.length; //perulangan untuk menyimpan array
                 a++) {
                final long persen = 100L * a / mhs.length;
                final String nama = mhs[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setMessage((int) persen + "& - Adding " + nama);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listNama.add(mhs[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //method sesudah asynctask sudah dijalankan
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listMhsw.setAdapter(adapter);
            dialog.dismiss();
        }
    }
}
