package com.iesvirgendelcarmen.dam.ejercicio_01a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ejercicio_01A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_01a);
    }

    public void boton1a(View view){
        Intent intent = new Intent(this, Ejercicio_01C.class);
        startActivity(intent);
    }

    public void boton2a(View view){
        Intent intent = new Intent(this, Ejercicio_01E.class);
        startActivity(intent);
    }

    public void onPause(){
        super.onPause();
        finish();
    }
}