package com.android.schemas.beranda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ImageButton imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageButton) findViewById(R.id.idImageButton);
    }

    public void onImageClick(View v){
        Toast.makeText(this,"Image was Clicked",Toast.LENGTH_SHORT).show();
    }
}