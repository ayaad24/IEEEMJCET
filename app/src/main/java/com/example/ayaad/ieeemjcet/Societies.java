package com.example.ayaad.ieeemjcet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Societies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_societies);
    }
    public void ciscard(View v)
    {
        Intent intent = new Intent(this, cis_card.class);
        startActivity(intent);
    }
    public void icscard(View v)
    {
        Intent intent = new Intent(this, ics_card.class);
        startActivity(intent);
    }
    public void pescard(View v)
    {
        Intent intent = new Intent(this, pes_card.class);
        startActivity(intent);
    }
    public void cascard(View v)
    {
        Intent intent = new Intent(this, cas_card.class);
        startActivity(intent);
    }
    public void wiecard(View v)
    {
        Intent intent = new Intent(this, wie_card.class);
        startActivity(intent);
    }
}
