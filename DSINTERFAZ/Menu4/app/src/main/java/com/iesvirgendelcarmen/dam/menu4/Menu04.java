package com.iesvirgendelcarmen.dam.menu4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Menu04 extends AppCompatActivity {
    private TextView etiqueta ;
    private TextView respuesta ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu04);
        etiqueta = (TextView)findViewById(R.id.mensaje);
        respuesta= (TextView)findViewById(R.id.respuesta);
        registerForContextMenu(etiqueta);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo
            menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu05, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Opc1:
                respuesta.setText("Etiqueta: OPCIÓN A PULSADA");
                return true;
            case R.id.Opc2:
                respuesta.setText("Etiqueta: OPCIÓN B PULSADA");
                return true;
            case R.id.Opc3:
                respuesta.setText("Etiqueta: OPCIÓN C PULSADA");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}


