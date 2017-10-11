package com.iesvirgendelcarmen.dam.formularyedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class FormularyEdit extends AppCompatActivity {

    final String[] ARTISTAS = {"MIGUEL ANGEL","LEONARDO","BOTICELLI","DONATELLO", "MANUEL"};
    final String[] PAISES = {"ESPAÑA","FRANCIA","ALEMANIA","EEUU", "CHINA","JAPÓN","CHILE"};
    final String[] CIUDADES = {"Jaén","Granada","Córdoba","Sevilla","Málaga","Almería","Cádiz","Huelva"};

    private Spinner spinner = (Spinner) findViewById(R.id.spinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulary_edit);

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


        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,CIUDADES));

       /* spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ciudad = (String) parent.getIemAtPosition(position);
            }
        });*/


       Button button = (Button) findViewById(R.id.leer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ciudad = (String) spinner.getSelectedItem();
            }
        });

    }


}
