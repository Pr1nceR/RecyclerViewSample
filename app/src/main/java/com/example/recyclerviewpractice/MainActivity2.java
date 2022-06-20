package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("NAME");
        String desc = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTv = findViewById(R.id.textView3);
        TextView descTv = findViewById(R.id.textView4);
        ImageView imageView = findViewById(R.id.imageView2);

        imageView.setImageResource(image);
        descTv.setText(desc);
        nameTv.setText(name);
    }
}