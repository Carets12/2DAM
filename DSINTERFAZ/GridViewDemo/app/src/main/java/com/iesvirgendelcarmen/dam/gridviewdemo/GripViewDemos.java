package com.iesvirgendelcarmen.dam.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GripViewDemos extends AppCompatActivity {

    private ArrayList<Contacto>agenda;
    private ContactoAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grip_view_demos);

        agenda = new ArrayList<Contacto>();
        mockAgenda();

        GridView miGridVIew = (GridView) findViewById(R.id.agenda);
        adaptador = new ContactoAdapter(this, agenda);
        miGridVIew.setAdapter(adaptador);
    }

    public void mockAgenda(){

        Contacto c ;
        c = new Contacto("Dani", "Sierra Raez", R.drawable.batman);
        agenda.add(c);


        c = new Contacto("Pepa", "Sierra Raez", R.drawable.mujer);
        agenda.add(c);


        c = new Contacto("Pepe", "Sierra Raez", R.drawable.batman);
        agenda.add(c);


        c = new Contacto("Laura", "Sierra Raez", R.drawable.mujer);
        agenda.add(c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int seleccionado = item.getItemId();

        switch (seleccionado){
            case R.id.opcion1:
                Toast.makeText(this, "Se ha pulsado opcion1", Toast.LENGTH_LONG).show();
                return true;

        }

        switch (seleccionado){
            case R.id.opcion2:
                Toast.makeText(this, "Se ha pulsado opcion2", Toast.LENGTH_LONG).show();
                return true;


            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}
