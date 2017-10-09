package com.iesvirgendelcarmen.dam.formularyedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class FormularyEdit extends AppCompatActivity {

    final String[] ARTISTAS = {"MIGUEL ANGEL","LEONARDO","BOTICELLI","DONATELLO", "MANUEL"};
    final String[] PAISES = {"ESPAÑA","FRANCIA","ALEMANIA","EEUU", "CHINA","JAPÓN","CHILE"};
    final String[] CIUDADES = {"Jaén","Granada","Córdoba","Sevilla","Málaga","Almería","Cádiz","Huelva"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulary_edit);

        Button leer;

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line,ARTISTAS);

        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line,PAISES);


        AutoCompleteTextView texto1 = (AutoCompleteTextView)
                findViewById(R.id.TextoAuto);
                texto1.setAdapter(adaptador);

        MultiAutoCompleteTextView texto = (MultiAutoCompleteTextView)
                findViewById(R.id.TextoMultiAuto);

        texto.setAdapter(adaptador1);
        texto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,CIUDADES));
        
    }
}
