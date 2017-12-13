package com.iesvirgendelcarmen.noticiasdeportes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iesvirgendelcarmen.noticiasdeportes.adaptadores.NoticiasAdapter;
import com.iesvirgendelcarmen.noticiasdeportes.adaptadores.UsuariosAdaptador;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.Usuario;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.api.NewsApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matinal on 13/12/17.
 */

public class UsuariosActivity extends AppCompatActivity{

    public static final String EXTRA_NOTICIA = "EXTRA_USUARIO";

    @BindView(R.id.listaUsuarios)
    ListView listViewUsuarios;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<Usuario> listaUsuarios;
    private UsuariosAdaptador usuariosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        cargarDatos();
        setLayout();
    }

    /**
     * Configuración de la vista
     */
    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);

        //Evento click en item de la lista
        listViewUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Se lanza la Activity de detalles de la noticia
                Intent intent = new Intent(UsuariosActivity.this, NoticiasDetalleActivity.class);
                intent.putExtra(EXTRA_NOTICIA, listaUsuarios.get(i));
                startActivity(intent);
            }
        });
    }

    /**
     * Obtiene una lista de noticias usando la API pública newsapi.org
     * <p>
     * Se usa un callback para recibir la lista.
     */

    private void cargarDatos(){
        NewsApi api = new NewsApi();
        api.ultimasNoticias(this, new NewsApi.Callback() {
            @Override
            public void getLista(List<Usuario> usuarios) {
                listaUsuarios = usuarios;
                //Se instancia adaptador
                usuariosAdapter = new UsuariosAdaptador(UsuariosActivity.this, listaUsuarios);
                listViewUsuarios.setAdapter(usuariosAdapter);

            }
        });
    }
}
    /*
    private void cargaDatos() {
        NewsApi api = new NewsApi();
        api.ultimasNoticias(this, new NewsApi.Callback() {
            @Override
            public void getLista(List<Noticia> noticias) {
                listaUsuarios = usuarios;
                //Se instancia adaptador
                usuariosAdapter = new NoticiasAdapter(UsuariosActivity.this, listaUsuarios);
                listViewNoticias.setAdapter(noticiasAdapter);
            }
        });

    }*/

