package com.iesvirgendelcarmen.dam.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AltaActivity extends AppCompatActivity implements View.OnClickListener{
    EditText nombret, apellidost, telefonot, sexot;
    Button btnAlta, btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        nombret = (EditText) findViewById(R.id.nombreE);
        apellidost = (EditText) findViewById(R.id.apellidosE);
        telefonot = (EditText) findViewById(R.id.telefonoE);
        sexot = (EditText) findViewById(R.id.sexoE);

        btnAlta = (Button) findViewById(R.id.alta);
        btnBorrar = (Button) findViewById(R.id.borrar);

        btnAlta.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);

    }

    public void onClick(View view){

        String nombre = nombret.getText().toString();
        String apellidos = apellidost.getText().toString();
        String telefono = telefonot.getText().toString();
        String sexo = sexot.getText().toString();

        switch (view.getId()) {


            case R.id.alta:
                Log.e("AgendaNombre",nombre);
                Log.e("AgendaApellidos",apellidos);
                Log.e("AgendaTelefono",telefono);
                Log.e("AgendaSexo",sexo);

                break;

            case R.id.borrar:

                nombret.setText("");
                Log.e("AgendaNombre","Vacio"+nombre);
                String apellidosb = apellidost.getText().toString();
                String telefonob = telefonot.getText().toString();
                String sexob = sexot.getText().toString();
                Log.e("AgendaApellidos",apellidosb);
                Log.e("AgendaTelefono",telefonob);
                Log.e("AgendaSexo",sexob);

                break;
            }



        }

}
