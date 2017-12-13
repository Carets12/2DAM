package es.vcarmen.exameniu2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * DANIEL SIERRA RÁEZ
 */

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Producto>productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Intent inten = new Intent(this, ListaProductoActivity.class);
        startActivity(inten);
*/
    }

    public ArrayList<Producto> getlistaProductos() {
        return productos;
    }

    public static void setlistaProductos(ArrayList<Producto> productos) {
        MainActivity.productos = productos;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.formulario:

                Intent inten1 = new Intent(this, Formulario.class);
                startActivity(inten1);

                return true;
            case R.id.lista:

                Intent inten = new Intent(this, ListaProductoActivity.class);
                startActivity(inten);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
