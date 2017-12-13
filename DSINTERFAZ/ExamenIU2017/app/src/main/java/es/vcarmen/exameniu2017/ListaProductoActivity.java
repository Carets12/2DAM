package es.vcarmen.exameniu2017;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * DANIEL SIERRA RÁEZ
 */

public class ListaProductoActivity extends AppCompatActivity {
    AdaptadorLista adaptadorLista;
    public static ArrayList<Producto> listaProductos;
    MainActivity main;
    Producto p, p1,p2,p3;
    ListView lista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_producto);
        listaProductos = new ArrayList<Producto>();

        lista = (ListView) findViewById(R.id.listaPoducto);

        p1 = new Producto("Laptor", "La mejor laptop", "300", "El mejor Pc", "12/12/2017");
        p2 = new Producto("Laptor", "La mejor laptop", "300", "El mejor Pc", "12/12/2017");
        p3 = new Producto("Laptor", "La mejor laptop", "300", "El mejor Pc", "12/12/2017");

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);

       //listaProductos = main.getlistaProductos();

        adaptadorLista = new AdaptadorLista(this,listaProductos);

        lista.setAdapter(adaptadorLista);

        Log.v("ListaProductoActivity", listaProductos.toString());

        main.setlistaProductos(listaProductos);
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static void setListaProductos(ArrayList<Producto> listaProductos) {
        ListaProductoActivity.listaProductos = listaProductos;
    }
}
