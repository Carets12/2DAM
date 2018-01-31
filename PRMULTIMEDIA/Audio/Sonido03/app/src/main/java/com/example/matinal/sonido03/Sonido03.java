package com.example.matinal.sonido03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sonido03 extends AppCompatActivity {

    Button inicio, parar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio03);

        inicio = findViewById(R.id.inicio);
        parar = findViewById(R.id.parar);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), Servicio.class));
            }
        });

        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(),Servicio.class));
            }
        });

    }
}
