package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<ZodiacSignModel>zodiacSignModels = new ArrayList<>();
    ZodiacRecyclerViewAdapter adapter;

    int[] zodiacSignImages = {
            R.drawable.aquarius, R.drawable.aries,R.drawable.cancer,
            R.drawable.capricorn,R.drawable.gemini,R.drawable.leo,
            R.drawable.libra,R.drawable.pisces,R.drawable.sagittarius,
            R.drawable.scorpio,R.drawable.taurus,R.drawable.virgo1
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setZodiacSignModels();

        adapter = new ZodiacRecyclerViewAdapter(this,
                zodiacSignModels,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setZodiacSignModels(){
      String[] zodiacSignName = getResources().getStringArray(R.array.zodiac_signs);
      String[] zodiacSignDesc = getResources().getStringArray(R.array.zodiac_description);

      for (int i = 0 ; i<zodiacSignName.length;i++){
          zodiacSignModels.add(new ZodiacSignModel(zodiacSignName[i],zodiacSignDesc[i],zodiacSignImages[i]));
      }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);

        intent.putExtra("NAME", zodiacSignModels.get(position).getZodiacSignName());
        intent.putExtra("DESCRIPTION", zodiacSignModels.get(position).getZodiacSignDesc());
        intent.putExtra("IMAGE", zodiacSignModels.get(position).getImage());

        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position) {
        zodiacSignModels.remove(position);
        adapter.notifyItemRemoved(position);
    }
}