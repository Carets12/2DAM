package com.iesvirgendelcarmen.dam.fragment10;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Fragment10 extends FragmentActivity implements Fragmento1.Callbacks {

    private boolean dosFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment10);

        if(findViewById(R.id.fragme_contenedor) != null ){
            dosFragmentos =true;

        }

    }

    @Override
    public void onEntradaSeleccionada(String id) {
        //Toast.makeText(getBaseContext(), "TOCADO EL " + id, Toast.LENGTH_SHORT).show();


        if (dosFragmentos){
            Log.v("Test","111111");
            Bundle arguments = new Bundle();
            arguments.putString(Fragmento3.ARG_ID_eNTRADA_SELECCIONADA, id);
            Fragmento3 fragment = new Fragmento3();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragme_contenedor, fragment).commit();

        }else{
            Log.v("Test","22222");
            Intent detalleItent = new Intent(this, Fragmento2.class);
            detalleItent.putExtra(Fragmento3.ARG_ID_eNTRADA_SELECCIONADA,id);
            startActivity(detalleItent);



        }

    }
}
