package com.iesvirgendelcarmen.dam.ejercicio_01a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Ejercicio_01B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_01b);
    }

    public void boton1b(View view){
        Intent intent = new Intent(this, Ejercicio_01E.class);
        startActivity(intent);

    }

    public void boton2b(View view){
        Intent intent = new Intent(this, Ejercicio_01F.class);
        startActivity(intent);

    }

    public void onPause(){
        super.onPause();
        finish();
    }
}
