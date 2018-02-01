package danielymiguel.tiendamvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import danielymiguel.tiendamvp.listaArticulos.ArticulosActivity;
import danielymiguel.tiendamvp.menu.MenuInterface;
import danielymiguel.tiendamvp.menu.MenuPresenter;

public class MainActivity extends AppCompatActivity implements MenuInterface.View{

    private MenuInterface.Presenter presentador = MenuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(presentador);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

/*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(MenuPresenter menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.informacionM) {
            //Activity del menu informacioM
            AlertDialog.Builder about = new AlertDialog.Builder(MainActivity.this);
            about.setTitle("Acerca de la aplicacion:");
            about.setMessage("TiendaMVP es una tiendaOnline que gestiona la venta de productos\n" +
                    "\n"+"TiendaMVP ha sido desarrollado como proyecto de la asignatura 'Desarrollo de Interfazes'" +
                    " cuyo objetivo es el aprendizaje de android. \n " +
                    "\nEsta version aún esta en Alpha con algunos Bugs.\n" +
                    "\n::app:: Realizada por: Daniel Sierra Ráez y Miguel Castillo Palomo\n" +
                    "\n:: GITLAB ::\nhttps://gitlab.iesvirgendelcarmen.com/miguelin9/TiendaMVP");
            about.setCancelable(false);

            about.setPositiveButton("Okey :)",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            about.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inicioM) {
            Intent intent = new Intent(AppContexto.getContexto(), getClass());
            startActivity(intent);
            //Activity del menu inicioM

        } else if (id == R.id.listaM) {
            //Activity del menu listaM
            Intent intent = new Intent(AppContexto.getContexto(), ArticulosActivity.class);
            startActivity(intent);

        } else if (id == R.id.anadirM) {
            //Activity del menu anadirM

        } else if (id == R.id.inventarioM) {
            //Activity del menu inventarioM

        } else if (id == R.id.categoriasM) {
            //Activity del menu categoriasM

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
