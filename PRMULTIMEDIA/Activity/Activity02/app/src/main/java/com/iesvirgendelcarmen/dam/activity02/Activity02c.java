package com.iesvirgendelcarmen.dam.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Activity02c extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02c);
        Log.v("Momento","Estoy en create3");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Momento","Estoy en start3");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Momento","Estoy en resume3");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Momento","Estoy en pause3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Momento","Estoy en destroy3");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Momento","Estoy en stop3");
    }

    public void boton2 (View view){
        finish();
    }

    public void boton1 (View view){
        Intent intent = new Intent (this, Activity02d.class);
        startActivity(intent);
    }
}
