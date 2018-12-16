package com.gzeinnumer.recyclerviewcardviewgridviewinstastyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TampilGambar extends AppCompatActivity {

    ImageView imageView;
    TextView textNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_gambar);
        imageView = findViewById(R.id.tampilGambar);
        textNama = findViewById(R.id.tampilNama);
        Intent intent= getIntent();
        int imageIndex = intent.getIntExtra("index",0);


        imageView.setImageResource(MainActivity.mImage[imageIndex]);
        textNama.setText(MainActivity.mName[imageIndex]);


    }
}
