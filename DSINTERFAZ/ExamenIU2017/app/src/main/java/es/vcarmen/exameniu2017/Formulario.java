package es.vcarmen.exameniu2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * DANIEL SIERRA RÁEZ
 */

public class Formulario extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Producto> productos;
    Producto p ;
    Button vender;
    ListaProductoActivity lp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        productos = new ArrayList<Producto>();
        vender = (Button) findViewById(R.id.vender);

        vender.setOnClickListener(this);
    }

    public ArrayList<Producto> crearProducto(){

        String titulo = ((EditText)findViewById(R.id.titulo)).getText().toString();
        String descripcion = ((EditText)findViewById(R.id.descripcion)).getText().toString();
        String precio = ((EditText)findViewById(R.id.precio)).getText().toString();
        String categoria = ((EditText)findViewById(R.id.categoria)).getText().toString();
        String fecha = ((EditText)findViewById(R.id.fecha)).getText().toString();

        p = new Producto(titulo,descripcion,precio,categoria,fecha);
        productos.add(p);


        Log.v("ListaFormulario", productos.toString());
       // Log.v("ListaFormulario", .toString());

        return productos;
    }

    @Override
    public void onClick(View view) {
        crearProducto();
       // Log.v("ListaFormulario", productos.toString());

    }
}
