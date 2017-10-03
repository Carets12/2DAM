package com.iesvirgendelcarmen.dam.proyectobotones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProyectoBotones extends AppCompatActivity implements View.OnClickListener {

    private int numero = 0;
    private TextView tn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto_botones);

        tn = (TextView) findViewById(R.id.numero);
        tn.setText(numero+"");

        Button btnInc = (Button) findViewById(R.id.inc);
        Button btnDec = (Button) findViewById(R.id.decremental);

        btnInc.setOnClickListener(this);
        btnDec.setOnClickListener(this);

        /*
        btnInc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                numero++;
                tn.setText(numero+"");
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero > 0) {
                    numero--;
                    tn.setText(numero + "");
                }
            }
        });*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.inc:
                numero++;
                tn.setText(numero+"");
                break;

            case R.id.decremental:
                numero--;
                tn.setText(numero+"");
                break;
        }
    }
}

