package com.iesvirgendelcarmen.dam.ejercicio_01a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Ejercicio_01F extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_01f);
    }

    public void boton1f(View view){
        Intent intent = new Intent(this, Ejercicio_01A.class);
        startActivity(intent);

    }

    public void onPause(){
        super.onPause();
        finish();
    }
}
