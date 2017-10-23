package com.iesvirgendelcarmen.dam.bundletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int contador = 0;

    private Button contadorB;
    private TextView texto;
    public final static String CONTADOR = "CONTADOR";
    public final static String PERSONA = "PERSONA";
    /*public final static String AGENDA = "AGENDA";*/
    private Persona p;
    /*private ArrayList<Persona> agenda;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorB = (Button) findViewById(R.id.contadorB);

        texto = (TextView) findViewById(R.id.texto);
        contadorB.setOnClickListener(this);

        if(savedInstanceState != null){
            contador = savedInstanceState.getInt(CONTADOR);
            p = (Persona) savedInstanceState.getSerializable(PERSONA);



          /*  agenda = (ArrayList<Persona>) savedInstanceState.getSerializable(AGENDA);*/
            texto.setText(p.toString());

        }

    }

    public void onClick (View view){
        contador ++;
        texto.setText(contador+"");

        p = new Persona("Daniel","Sierra Ráez");
        texto.setText(p.toString());
        //agenda.add(p);
        /*p = new Persona("Antonio","Perez Garzon");
        agenda.add(p);*/

    }

    //guardar el valor

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CONTADOR, contador);
        outState.putSerializable(PERSONA,p);
       /* outState.putSerializable(AGENDA,agenda);*/
    }
}
