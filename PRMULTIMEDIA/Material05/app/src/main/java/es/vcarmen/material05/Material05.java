package es.vcarmen.material05;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Material05 extends AppCompatActivity {

    Toolbar toolbar;
    Snackbar snackbar;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material05);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void mensaje (int resid){
        Toast.makeText(this,getText(resid),Toast.LENGTH_SHORT).show();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.barra_nuevo:
                mensaje(R.string.cadena_barra_nuevo);
                snackbar = Snackbar.make(coordinatorLayout, "AÑADIR", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;

            case R.id.barra_editar:
                mensaje(R.string.cadena_barra_editar);
                snackbar = Snackbar.make(coordinatorLayout, "EDITAR", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;

            case R.id.barra_configurar:
                mensaje(R.string.cadena_barra_configurar);
                snackbar = Snackbar.make(coordinatorLayout, "CONFIGURAR", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;

            case R.id.barra_ayuda:
                mensaje(R.string.cadena_barra_ayuda);
                snackbar = Snackbar.make(coordinatorLayout, "AYUDA", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;

            case R.id.barra_acerca:
                mensaje(R.string.cadena_barra_acerca);
                snackbar = Snackbar.make(coordinatorLayout, "ACERCA DE..", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;

            default:return super.onOptionsItemSelected(item);
        }
    }
}
