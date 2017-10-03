package com.iesvirgendelcarmen.dam.ejercicio_01a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Ejercicio_01E extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_01e);
    }

    public void boton1e(View view){
        Intent intent = new Intent(this, Ejercicio_01B.class);
        startActivity(intent);

    }

    public void boton2e(View view){
        Intent intent = new Intent(this, Ejercicio_01D.class);
        startActivity(intent);

    }

    public void onPause(){
        super.onPause();
        finish();
    }
}
