package com.iesvirgendelcarmen.dam.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListViewDemo extends AppCompatActivity {

    ListView listaView;
    ArrayList<Persona> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        lista = mockLista();

        listaView = (ListView) findViewById(R.id.listaNombres);

        /*ArrayAdapter<Persona> adaptador = new ArrayAdapter<Persona>
                (this, android.R.layout.simple_list_item_1, lista);

        listaView.setAdapter(adaptador);*/

        PersonaAdapter adaptador = new PersonaAdapter(this, lista);
        listaView.setAdapter(adaptador);
    }

    private ArrayList<Persona> mockLista(){
        ArrayList<Persona> lista = new ArrayList<Persona>();

        Persona p1 = new Persona ("Luis","Molina Garzón");
        lista.add(p1);

        Persona p2 = new Persona ("Daniel","Sierra Ráez");
        lista.add(p2);

        Persona p4 = new Persona ("Ana","Ramirez Cochuelo");
        lista.add(p4);

        Persona p3 = new Persona ("Luis","Zamora Garzón");
        lista.add(p3);

        Persona p5 = new Persona ("Pepeillo","Gurch Morn");
        lista.add(p5);

        Persona p6 = new Persona ("Ines","Cheis Zurk");
        lista.add(p6);

        Persona p7 = new Persona ("Maria","Pantoja Lia");
        lista.add(p7);

        return lista;
    }
}
