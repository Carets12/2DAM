package com.iesvirgendelcarmen.dam.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Activity02b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02b);
        Log.v("Momento","Estoy en create2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Momento","Estoy en start2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Momento","Estoy en resume2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Momento","Estoy en pause2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Momento","Estoy en destroy2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Momento","Estoy en stop2");
    }

    public void boton2 (View view){
        finish();
    }

    public void boton1 (View view){
        Intent intent = new Intent (this, Activity02c.class);
        startActivity(intent);
    }
}
